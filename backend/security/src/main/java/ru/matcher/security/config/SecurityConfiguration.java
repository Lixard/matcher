package ru.matcher.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import ru.matcher.data.DataConfiguration;

/**
 * В данном модуле будет реализована инициализация компонента безопасности Spring.
 * Прописаны главные пути и права доступа.
 *
 * @author Maxim Borisov
 */
@Configuration
@Import({
        DataConfiguration.class
})
@ComponentScan("ru.matcher.security")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationEntryPoint entryPoint;
    private final AuthenticationSuccessHandler loginSuccessHandler;
    private final LogoutSuccessHandler logoutSuccessHandler;
    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfiguration(AuthenticationEntryPoint entryPoint,
                                 AuthenticationSuccessHandler loginSuccessHandler,
                                 LogoutSuccessHandler logoutSuccessHandler,
                                 @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.entryPoint = entryPoint;
        this.loginSuccessHandler = loginSuccessHandler;
        this.logoutSuccessHandler = logoutSuccessHandler;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        final var provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        auth.authenticationProvider(provider);
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/auth/login")
                .successHandler(loginSuccessHandler)
                .and()
                .logout()
                .logoutUrl("/auth/logout")
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement()
                .sessionFixation()
                .changeSessionId();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
