package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.matcher.data.model.Picture;
import ru.matcher.data.model.User;
import ru.matcher.services.dto.UserDto;
import ru.matcher.services.dto.create.UserCreateDto;

import java.util.List;

/**
 * Маппер для пользователя.
 *
 * @author Николай Евсюков
 * @author Андрей Герасимов
 * @author Максим Щербаков
 */
@Mapper
public interface UserStruct {

    /**
     * Превращение User в UserDto.
     *
     * @param user объект класса User
     * @return объект класса UserDto
     */
    @Mapping(target = "pictureId", source = "picture.id")
    @Mapping(target = "userType", source = "userType")
    UserDto toDto(User user);

    /**
     * Превращение UserDto в User.
     *
     * @param userDto объект класса UserDto
     * @return объект класса User
     */
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "login", ignore = true)
    @Mapping(target = "competencies", ignore = true)
    @Mapping(target = "picture", source = "pictureId", qualifiedByName = "setPictureId")
    @Mapping(target = "userType", source = "userType")
    User fromDto(UserDto userDto);


    /**
     * Создание сущности пользователя с данными для входа из DTO.
     *
     * @param dto dto для конвертации
     * @return сущность пользователя
     */
    @Mapping(target = "competencies", ignore = true)
    @Mapping(target = "picture", source = "pictureId", qualifiedByName = "setPictureId")
    User fromDto(UserCreateDto dto);

    @Named("setPictureId")
    default Picture setPictureId(Integer pictureId) {
        if (pictureId == null) {
            return null;
        }
        final var picture = new Picture();
        picture.setId(pictureId);
        return picture;
    }

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
