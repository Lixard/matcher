package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.matcher.data.model.Organization;
import ru.matcher.data.model.Project;
import ru.matcher.services.dto.ProjectDto;
import ru.matcher.services.dto.create.ProjectCreateDto;

import java.util.List;

/**
 * Маппер для проектов.
 *
 * @author Николай Евсюков
 */
@Mapper
public interface ProjectStruct {

    /**
     * Превращение Project в ProjectDto.
     *
     * @param project объект класса Project
     * @return объект класса ProjectDto
     */
    @Mapping(target = "organizationId", source = "organization.id")
    ProjectDto toDto(Project project);

    /**
     * Превражение ProjectDto в Project.
     *
     * @param projectDto объект класса ProjectDto
     * @return объект класса Project
     */
    @Mapping(target = "files", ignore = true)
    @Mapping(target = "organization", source = "organizationId", qualifiedByName = "setOrganizationId")
    Project fromDto(ProjectDto projectDto);

    /**
     * Создание сущности проекта с данными для входа из DTO.
     *
     * @param dto dto для конвертации
     * @return сущность проекта
     */
    @Mapping(target = "files", ignore = true)
    @Mapping(target = "organization", source = "organizationId", qualifiedByName = "setOrganizationId")
    Project fromDto(ProjectCreateDto dto);

    /**
     * Превращение списка Project в список ProjectDto.
     *
     * @param projects список Project
     * @return список ProjectDto
     */
    List<ProjectDto> toDto(List<Project> projects);

    /**
     * Превращение списка ProjectDto в список Project.
     *
     * @param projectDtos список ProjectDto
     * @return список Project
     */
    List<Project> fromDto(List<ProjectDto> projectDtos);

    @Named("setOrganizationId")
    default Organization setOrganizationId(Integer organizationId) {
        if (organizationId == null) {
            return null;
        }
        final var organization = new Organization();
        organization.setId(organizationId);
        return organization;
    }

}
