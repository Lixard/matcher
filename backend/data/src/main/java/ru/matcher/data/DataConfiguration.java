package ru.matcher.data;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Данный модуль является нижнем уровнем сервера. В нем будет происходить всё взаимодействие с базой данных.
 *
 * @author Maxim Borisov
 */
@EntityScan(basePackages = "ru.matcher.data.model")
@Configuration
@ComponentScan
public class DataConfiguration {
}
