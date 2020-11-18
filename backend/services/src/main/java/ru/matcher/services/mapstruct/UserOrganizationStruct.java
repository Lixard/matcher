package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.matcher.data.model.UserOrganization;
import ru.matcher.services.dto.UserOrganizationDto;

import java.util.List;

/**
 * Маппер для организаций пользователя.
 *
 * @author Николай Евсюков
 */
@Mapper
public interface UserOrganizationStruct {

    /**
     * Превращение UserOrganization в UserOrganizationDto.
     *
     * @param userOrganization объект класса UserOrganization
     * @return объект класса UserOrganizationDto
     */
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "organizationId", target = "organization.id")
    UserOrganizationDto toDto(UserOrganization userOrganization);

    /**
     * Превражение UserOrganizationDto в UserOrganization.
     *
     * @param userOrganizationDto объект класса UserOrganizationDto
     * @return объект класса UserOrganization
     */
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "organization.id", target = "organizationId")
    UserOrganization fromDto(UserOrganizationDto userOrganizationDto);

    /**
     * Превращение списка UserOrganization в список UserOrganizationDto.
     *
     * @param userOrganizations список UserOrganization
     * @return список UserOrganizationDto
     */
    List<UserOrganizationDto> toDto(List<UserOrganization> userOrganizations);

    /**
     * Превращение списка UserOrganizationDto в список UserOrganization.
     *
     * @param userOrganizationDtos список UserOrganizationDto
     * @return список UserOrganization
     */
    List<UserOrganization> fromDto(List<UserOrganizationDto> userOrganizationDtos);
}