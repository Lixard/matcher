package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matcher.data.model.User;

import java.util.Optional;

/**
 * Репозиторий для пользователей.
 *
 * @author Николай Евсюков
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String login);
}
