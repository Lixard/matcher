package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import ru.matcher.data.model.Project;
import ru.matcher.services.dto.ProjectDto;

import java.util.List;

@Mapper
public interface ProjectStruct {

    ProjectDto toDto(Project project);

    Project fromDto(ProjectDto projectDto);

    List<ProjectDto> toDto(List<Project> projects);

    List<Project> fromDto(List<ProjectDto> projectDtos);
}
