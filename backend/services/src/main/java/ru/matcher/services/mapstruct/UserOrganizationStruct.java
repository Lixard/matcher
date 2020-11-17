package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import ru.matcher.data.model.UserOrganization;
import ru.matcher.services.dto.UserOrganizationDto;

import java.util.List;

@Mapper
public interface UserOrganizationStruct {

    UserOrganizationDto toDto(UserOrganization userOrganization);

    UserOrganization fromDto(UserOrganizationDto userOrganizationDto);

    List<UserOrganizationDto> toDto(List<UserOrganization> userOrganizations);

    List<UserOrganization> fromDto(List<UserOrganizationDto> userOrganizationDtos);
}
