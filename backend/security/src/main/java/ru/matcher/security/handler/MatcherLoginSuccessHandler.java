package ru.matcher.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.matcher.security.model.ICurrentUser;
import ru.matcher.security.model.LoginSuccessModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MatcherLoginSuccessHandler implements AuthenticationSuccessHandler {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        if (!(authentication.getPrincipal() instanceof ICurrentUser)) {
            throw new AuthenticationServiceException("User instance not of login info");
        }

        final var principal = (ICurrentUser) authentication.getPrincipal();
        final var successModel = new LoginSuccessModel(principal);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print(OBJECT_MAPPER.writeValueAsString(successModel));
    }
}
