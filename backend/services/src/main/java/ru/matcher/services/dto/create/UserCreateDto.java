package ru.matcher.services.dto.create;

import ru.matcher.services.dto.UserDto;

/**
 * DTO для создания пользователя.
 *
 * @author Maxim Borisov
 */
public class UserCreateDto extends UserDto {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
