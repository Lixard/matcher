package ru.matcher.services.service;

import ru.matcher.services.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createOrUpdate(UserDto userDto);

    void remove(int userId);

    List<UserDto> getUsers();

    UserDto findById(int userId);
}
