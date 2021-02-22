package ru.matcher.security.model;

/**
 * Модель ошибки авторизации.
 *
 * @author Maxim Borisov
 */
public class AuthErrorModel {

    private boolean authenticated;

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
