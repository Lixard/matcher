package ru.matcher.security.model;

/**
 * Интерфейс, представляющий собой текущего (залогиненного) пользователя системы.
 *
 * @author Maxim Borisov
 */
public interface ICurrentUser {

    int getId();

    String getLogin();

    boolean getAuthenticated();
}
