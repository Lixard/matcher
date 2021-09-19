package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.Project;
import ru.matcher.data.repository.ProjectParticipationRepository;
import ru.matcher.data.repository.ProjectRepository;
import ru.matcher.services.dto.ProjectDto;
import ru.matcher.services.dto.ProjectParticipationDto;
import ru.matcher.services.mapstruct.ProjectParticipationStruct;
import ru.matcher.services.mapstruct.ProjectStruct;
import ru.matcher.services.service.IProjectService;

import java.util.ArrayList;
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
    private final ProjectParticipationRepository projectParticipationRepository;
    private final ProjectParticipationStruct projectParticipationStruct;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,
                              ProjectStruct projectStruct, ProjectParticipationRepository projectParticipationRepository, ProjectParticipationStruct projectParticipationStruct) {
        this.projectRepository = projectRepository;
        this.projectStruct = projectStruct;
        this.projectParticipationRepository = projectParticipationRepository;
        this.projectParticipationStruct = projectParticipationStruct;
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

    @Override
    public List<ProjectDto> getProjectsByUserId(Integer userId) {
        List<ProjectParticipationDto> projectParticipations = projectParticipationStruct.toDto(projectParticipationRepository.findByUserId(userId));
        List<ProjectDto> projectDtos = new ArrayList<>();
        for (ProjectParticipationDto projectParticipation : projectParticipations) {
            projectDtos.add(projectStruct.toDto(projectRepository.findById(projectParticipation.getProjectId()).orElse(null)));
        }
        return projectDtos;
    }
}
