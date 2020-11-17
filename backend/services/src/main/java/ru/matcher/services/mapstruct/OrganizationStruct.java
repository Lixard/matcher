package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import ru.matcher.data.model.Organization;
import ru.matcher.services.dto.OrganizationDto;

import java.util.List;

/**
 * Маппер для организации.
 *
 * @author Николай Евсюков
 */
@Mapper
public interface OrganizationStruct {

    /**
     * Превращение Organization в OrganizationDto.
     *
     * @param organization объект класса Organization
     * @return объект класса OrganizationDto
     */
    OrganizationDto toDto(Organization organization);

    /**
     * Превражение OrganizationDto в Organization.
     *
     * @param organizationDto объект класса OrganizationDto
     * @return объект класса Organization
     */
    Organization fromDto(OrganizationDto organizationDto);

    /**
     * Превращение списка Organization в список OrganizationDto.
     *
     * @param organizations список Organization
     * @return список OrganizationDto
     */
    List<OrganizationDto> toDto(List<Organization> organizations);

    /**
     * Превращение списка OrganizationDto в список Organization.
     *
     * @param organizationDtos список OrganizationDto
     * @return список Organization
     */
    List<Organization> fromDto(List<OrganizationDto> organizationDtos);
}
