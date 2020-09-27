package ru.matcher.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.matcher.data.DataConfiguration;

/**
 * Данный модуль является средним уровнем сервера. В нём будет реализовываться вся бизнес-логика приложения.
 *
 * @author Maxim Borisov
 */
@Configuration
@ComponentScan
@Import({
        DataConfiguration.class
})
public class ServicesConfiguration {
}
