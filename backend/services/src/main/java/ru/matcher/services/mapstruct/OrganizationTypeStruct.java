package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import ru.matcher.data.model.OrganizationType;
import ru.matcher.services.dto.OrganizationTypeDto;

import java.util.List;

/**
 * Маппер для типа организации.
 *
 * @author Николай Евсюков
 */
@Mapper
public interface OrganizationTypeStruct {

    /**
     * Превращение OrganizationType в OrganizationTypeDto.
     *
     * @param organizationType объект класса OrganizationType
     * @return объект класса OrganizationTypeDto
     */
    OrganizationTypeDto toDto(OrganizationType organizationType);

    /**
     * Превращение OrganizationTypeDto в OrganizationType.
     *
     * @param organizationTypeDto объект класса OrganizationTypeDto
     * @return объект класса OrganizationType
     */
    OrganizationType fromDto(OrganizationTypeDto organizationTypeDto);

    /**
     * Превращение списка OrganizationType в список OrganizationTypeDto.
     *
     * @param organizationTypes список OrganizationType
     * @return список OrganizationTypeDto
     */
    List<OrganizationTypeDto> toDto(List<OrganizationType> organizationTypes);

    /**
     * Превращение списка OrganizationTypeDto в список OrganizationType.
     *
     * @param organizationTypeDtos список OrganizationTypeDto
     * @return список OrganizationType
     */
    List<OrganizationType> fromDto(List<OrganizationTypeDto> organizationTypeDtos);
}
