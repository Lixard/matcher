package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.matcher.data.model.User;
import ru.matcher.security.service.IPasswordEncoderService;
import ru.matcher.services.dto.UserDto;
import ru.matcher.services.dto.create.UserCreateDto;

import java.util.List;

/**
 * Маппер для пользователя.
 *
 * @author Николай Евсюков
 */
@Mapper(uses = IPasswordEncoderService.class)
public interface UserStruct {

    /**
     * Превращение User в UserDto.
     *
     * @param user объект класса User
     * @return объект класса UserDto
     */
    @Mapping(target = "pictureId", source = "picture.id")
    UserDto toDto(User user);

    /**
     * Превращение UserDto в User.
     *
     * @param userDto объект класса UserDto
     * @return объект класса User
     */
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "login", ignore = true)
    @Mapping(target = "picture", ignore = true)
    @Mapping(target = "picture.id", source = "pictureId")
    User fromDto(UserDto userDto);


    /**
     * Создание сущности пользователя с данными для входа из DTO.
     *
     * @param dto dto для конвертации
     * @return сущность пользователя
     */
    @Mapping(target = "picture", ignore = true)
    @Mapping(target = "picture.id", source = "pictureId")
    User fromDto(UserCreateDto dto);

    /**
     * Превращение списка User в список UserDto.
     *
     * @param users список User
     * @return список UserDto
     */
    List<UserDto> toDto(List<User> users);

    /**
     * Превращение списка UserDto в список User.
     *
     * @param userDtos список UserDto
     * @return список User
     */
    List<User> fromDto(List<UserDto> userDtos);
}
