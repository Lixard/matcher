package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.Project;
import ru.matcher.data.model.UserOrganization;
import ru.matcher.data.repository.OrganizationRepository;
import ru.matcher.data.repository.PictureRepository;
import ru.matcher.data.repository.ProjectRepository;
import ru.matcher.data.repository.UserOrganizationRepository;
import ru.matcher.services.dto.OrganizationDto;
import ru.matcher.services.dto.PictureDto;
import ru.matcher.services.dto.ProjectDto;
import ru.matcher.services.dto.create.ProjectCreateDto;
import ru.matcher.services.mapstruct.OrganizationStruct;
import ru.matcher.services.mapstruct.PictureStruct;
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
    private final OrganizationStruct organizationStruct;
    private final UserOrganizationRepository userOrganizationRepository;
    private final OrganizationRepository organizationRepository;
    private final PictureRepository pictureRepository;
    private final PictureStruct pictureStruct;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,
                              ProjectStruct projectStruct, OrganizationStruct organizationStruct, UserOrganizationRepository userOrganizationRepository, OrganizationRepository organizationRepository, PictureRepository pictureRepository, PictureStruct pictureStruct) {
        this.projectRepository = projectRepository;
        this.projectStruct = projectStruct;
        this.organizationStruct = organizationStruct;
        this.userOrganizationRepository = userOrganizationRepository;
        this.organizationRepository = organizationRepository;
        this.pictureRepository = pictureRepository;
        this.pictureStruct = pictureStruct;
    }

    @Override
    @Transactional
    public ProjectDto create(ProjectCreateDto projectCreateDto) {
        UserOrganization userOrganization = userOrganizationRepository.findByIdUser(projectCreateDto.getUserId()).get(0);
        OrganizationDto organizationDto = organizationStruct.toDto(organizationRepository.findById(userOrganization.getId().getOrganization()).orElse(null));
        projectCreateDto.setOrganizationId(organizationDto.getId());
        Project project = projectStruct.fromDto(projectCreateDto);
        project.setPicture(pictureRepository.findById(projectCreateDto.getPictureId()).orElse(null));
        project.setActive(true);
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
