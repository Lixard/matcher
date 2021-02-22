package ru.matcher.security.mapper;

import org.mapstruct.Mapper;
import ru.matcher.security.model.CurrentUserDto;
import ru.matcher.security.model.ICurrentUser;

/**
 * Конвертер для преобразования модели {@link ICurrentUser} в его DTO.
 *
 * @author Maxim Borisov
 */
@Mapper(componentModel = "spring")
public interface CurrentUserMapper {

    /**
     * Преобразование {@link ICurrentUser} в {@link CurrentUserDto}.
     */
    CurrentUserDto toDto(ICurrentUser model);
}
