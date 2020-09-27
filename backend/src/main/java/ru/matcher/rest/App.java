package ru.matcher.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.matcher.services.ServicesConfiguration;

/**
 * Главный класс из которого происходит инициализация основного контекста приложения.
 * Данный модуль будет являться верхним уровнем приложения. В нем будут реализованы все конечные точки нашего REST API.
 *
 * @author Maxim Borisov
 */
@SpringBootApplication
@Import({
        ServicesConfiguration.class
})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
