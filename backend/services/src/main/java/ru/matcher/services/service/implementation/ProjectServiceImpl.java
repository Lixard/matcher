package ru.matcher.services.service.implementation;

import org.springframework.stereotype.Service;
import ru.matcher.data.model.Project;
import ru.matcher.data.repository.ProjectRepository;
import ru.matcher.services.dto.ProjectDto;
import ru.matcher.services.mapstruct.ProjectStruct;
import ru.matcher.services.service.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectStruct projectStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public ProjectServiceImpl(ProjectRepository projectRepository,
                              ProjectStruct projectStruct) {
        this.projectRepository = projectRepository;
        this.projectStruct = projectStruct;
    }

    @Override
    public ProjectDto createOrUpdate(ProjectDto projectDto) {
        Project project = projectStruct.fromDto(projectDto);
        projectRepository.save(project);
        return projectStruct.toDto(project);
    }

    @Override
    public void remove(int projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public List<ProjectDto> getProjects() {
        return projectStruct.toDto(projectRepository.findAll());
    }

    @Override
    public ProjectDto findById(int projectId) {
        return projectStruct.toDto(projectRepository.findById(projectId).orElseThrow());
    }
}
