package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto класс для пользователя.
 *
 * @author Николай Евсюков
 */
@Getter
@Setter
public class UserDto {

    private Integer id;
    private PictureGetDto pictureGetDto;
    private String firstName;
    private String lastName;
    private String secondName;
    private String email;
    private String phone;
}
