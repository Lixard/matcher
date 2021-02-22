package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.Project;
import ru.matcher.data.repository.ProjectRepository;
import ru.matcher.services.dto.ProjectDto;
import ru.matcher.services.mapstruct.ProjectStruct;
import ru.matcher.services.service.IProjectService;

import java.util.List;

/**
 * Реализация интерфейса ProjectService.
 *
 * @author Николай Евсюков
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectStruct projectStruct;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,
                              ProjectStruct projectStruct) {
        this.projectRepository = projectRepository;
        this.projectStruct = projectStruct;
    }

    @Override
    @Transactional
    public ProjectDto create(ProjectDto projectDto) {
        Project project = projectStruct.fromDto(projectDto);
        projectRepository.save(project);
        return projectStruct.toDto(project);
    }

    @Override
    @Transactional
    public ProjectDto update(ProjectDto projectDto) {
        Project project = projectStruct.fromDto(projectDto);
        projectRepository.save(project);
        return projectStruct.toDto(project);
    }

    @Override
    @Transactional
    public void remove(int projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public List<ProjectDto> getProjects() {
        return projectStruct.toDto(projectRepository.findAll());
    }

    @Override
    public ProjectDto findById(int projectId) {
        return projectStruct.toDto(projectRepository.findById(projectId).orElse(null));
    }
}
