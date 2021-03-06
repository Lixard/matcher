package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.matcher.data.model.Organization;
import ru.matcher.data.model.Picture;
import ru.matcher.services.dto.OrganizationDto;

import java.util.List;

/**
 * Маппер для организации.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
 */
@Mapper
public interface OrganizationStruct {

    /**
     * Превращение Organization в OrganizationDto.
     *
     * @param organization объект класса Organization
     * @return объект класса OrganizationDto
     */
    @Mapping(target = "pictureId", source = "picture.id")
    OrganizationDto toDto(Organization organization);

    /**
     * Превражение OrganizationDto в Organization.
     *
     * @param organizationDto объект класса OrganizationDto
     * @return объект класса Organization
     */
    @Mapping(target = "picture", source = "pictureId", qualifiedByName = "setPictureId")
    Organization fromDto(OrganizationDto organizationDto);

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
