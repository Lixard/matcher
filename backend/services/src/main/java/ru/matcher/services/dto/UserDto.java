package ru.matcher.services.dto;

import ru.matcher.services.dto.get.PictureGetDto;

/**
 * Dto класс для пользователя.
 *
 * @author Николай Евсюков
 */
public class UserDto {

    private Integer id;
    private PictureGetDto pictureGetDto;
    private String firstName;
    private String lastName;
    private String secondName;
    private String email;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PictureGetDto getPictureGetDto() {
        return pictureGetDto;
    }

    public void setPictureGetDto(PictureGetDto pictureGetDto) {
        this.pictureGetDto = pictureGetDto;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
