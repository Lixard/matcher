package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;
import ru.matcher.data.model.File;

/**
 * Dto класс для пользователя.
 *
 * @author Николай Евсюков
 */
@Getter
@Setter
public class UserDto {

    private Integer id;
    private File picture;
    private String firstName;
    private String lastName;
    private String secondName;
    private String email;
    private String phone;
}
