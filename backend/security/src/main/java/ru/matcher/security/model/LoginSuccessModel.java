package ru.matcher.security.model;

/**
 * Модель, представляющая собой ответ сервера на успешную авторизацию.
 */
public class LoginSuccessModel implements ICurrentUser {

    private int id;
    private String username;
    private boolean authenticated;

    public LoginSuccessModel() {
    }

    public LoginSuccessModel(ICurrentUser principal) {
        this.id = principal.getId();
        this.username = principal.getLogin();
        this.authenticated = principal.getAuthenticated();
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getLogin() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}

