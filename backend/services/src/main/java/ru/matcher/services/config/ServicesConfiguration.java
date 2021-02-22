package ru.matcher.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.matcher.data.DataConfiguration;
import ru.matcher.security.config.SecurityConfiguration;

/**
 * Данный модуль является средним уровнем сервера. В нём будет реализовываться вся бизнес-логика приложения.
 *
 * @author Maxim Borisov
 */
@Configuration
@ComponentScan({
        "ru.matcher.services.service",
        "ru.matcher.services.mapstruct"
})
@Import({
        DataConfiguration.class,
        SecurityConfiguration.class
})
public class ServicesConfiguration {
}
