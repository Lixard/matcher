package ru.matcher.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import ru.matcher.security.config.SecurityConfiguration;
import ru.matcher.services.config.ServicesConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Главный класс из которого происходит инициализация основного контекста приложения.
 * Данный модуль будет являться верхним уровнем приложения. В нем будут реализованы все конечные точки нашего REST API.
 *
 * @author Maxim Borisov
 */
@SpringBootApplication(scanBasePackages = "ru.matcher.rest")
@Import({
        ServicesConfiguration.class,
        SecurityConfiguration.class
})
@EnableSwagger2
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
