package ru.matcher.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import ru.matcher.security.model.ICurrentUser;

/**
 * Конфигурация, отвечающая за создание объекта с текущим авторизованным пользователем.
 *
 * @author Maxim Borisov
 */
@Configuration
public class CurrentUserConfig {

    private static final String ANONYMOUS_USER = "anonymousUser";

    /**
     * Создает текущего авторизованного пользователя. Является проксируемым, то есть, для каждого авторизованного
     * пользователя существует свой объект.
     *
     * @return объект текущего авторизованного пользователя, либо объект анонимного пользователя, если
     *         авторизованного нет
     */
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ICurrentUser currentUser() {
        final var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal == ANONYMOUS_USER) {
            return getDefaultUser();
        }
        return (ICurrentUser) principal;
    }

    private ICurrentUser getDefaultUser() {
        return new ICurrentUser() {
            @Override
            public int getId() {
                return -1;
            }

            @Override
            public String getLogin() {
                return null;
            }

            @Override
            public boolean getAuthenticated() {
                return false;
            }
        };
    }
}
