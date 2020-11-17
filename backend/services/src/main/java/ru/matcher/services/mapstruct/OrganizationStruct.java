package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import ru.matcher.data.model.Organization;
import ru.matcher.services.dto.OrganizationDto;

import java.util.List;

@Mapper
public interface OrganizationStruct {

    OrganizationDto toDto(Organization organization);

    Organization fromDto(OrganizationDto organizationDto);

    List<OrganizationDto> toDto(List<Organization> organizations);

    List<Organization> fromDto(List<OrganizationDto> organizationDtos);
}
