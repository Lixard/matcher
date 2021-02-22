package ru.matcher.data;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Данный модуль является нижнем уровнем сервера. В нем будет происходить всё взаимодействие с базой данных.
 *
 * @author Maxim Borisov
 */
@Configuration
@EntityScan(basePackages = "ru.matcher.data.model")
@EnableJpaRepositories(basePackages = "ru.matcher.data.repository")
@EnableTransactionManagement
public class DataConfiguration {
}
