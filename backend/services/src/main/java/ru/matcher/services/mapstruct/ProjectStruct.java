package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.matcher.data.model.Project;
import ru.matcher.services.dto.ProjectDto;

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
    @Mapping(target = "pictureId", source = "picture.id")
    ProjectDto toDto(Project project);

    /**
     * Превражение ProjectDto в Project.
     *
     * @param projectDto объект класса ProjectDto
     * @return объект класса Project
     */
    @Mapping(target = "picture.id", source = "pictureId")
    Project fromDto(ProjectDto projectDto);

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
}
