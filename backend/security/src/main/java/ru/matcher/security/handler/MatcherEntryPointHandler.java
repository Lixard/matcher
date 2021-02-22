package ru.matcher.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import ru.matcher.security.model.AuthErrorModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Обработчик, который модифицирует ответ, чтобы дать ему понять, что нужна аутентификация.
 *
 * @author Maxim Borisov
 */
@Component
public class MatcherEntryPointHandler implements AuthenticationEntryPoint {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * {@inheritDoc}
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        if (response.getStatus() != HttpServletResponse.SC_FORBIDDEN) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        final var errorModel = new AuthErrorModel();
        errorModel.setAuthenticated(false);
        response.getWriter().print(OBJECT_MAPPER.writeValueAsString(errorModel));
    }
}
