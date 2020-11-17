package ru.matcher.services.service;

import ru.matcher.services.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

    ProjectDto createOrUpdate(ProjectDto projectDto);

    void remove(int projectId);

    List<ProjectDto> getProjects();

    ProjectDto findById(int projectId);
}
