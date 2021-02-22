package ru.matcher.security.mapper;

import org.mapstruct.Mapper;
import ru.matcher.security.model.CurrentUserDto;
import ru.matcher.security.model.ICurrentUser;

@Mapper(componentModel = "spring")
public interface CurrentUserMapper {

    CurrentUserDto toDto(ICurrentUser model);
}
