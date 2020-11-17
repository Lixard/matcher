package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import ru.matcher.data.model.OrganizationType;
import ru.matcher.services.dto.OrganizationTypeDto;

import java.util.List;

@Mapper
public interface OrganizationTypeStruct {

    OrganizationTypeDto toDto(OrganizationType organizationType);

    OrganizationType fromDto(OrganizationTypeDto organizationTypeDto);

    List<OrganizationTypeDto> toDto(List<OrganizationType> organizationTypes);

    List<OrganizationType> fromDto(List<OrganizationTypeDto> organizationTypeDtos);
}
