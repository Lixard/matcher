package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import ru.matcher.data.model.User;
import ru.matcher.services.dto.UserDto;

import java.util.List;

@Mapper
public interface UserStruct {

    UserDto toDto(User user);

    User fromDto(UserDto userDto);

    List<UserDto> toDto(List<User> users);

    List<User> fromDto(List<UserDto> userDtos);
}
