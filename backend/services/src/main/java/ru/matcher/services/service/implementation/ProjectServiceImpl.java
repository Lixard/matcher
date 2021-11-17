package ru.matcher.services.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.Organization;
import ru.matcher.data.model.Project;
import ru.matcher.data.model.UserOrganization;
import ru.matcher.data.repository.*;
import ru.matcher.services.dto.*;
import ru.matcher.services.mapstruct.ProjectParticipationStruct;
import ru.matcher.services.dto.ProjectParticipationDto;
import ru.matcher.services.dto.create.ProjectCreateDto;
import ru.matcher.services.mapstruct.OrganizationStruct;
import ru.matcher.services.mapstruct.ProjectStruct;
import ru.matcher.services.service.IProjectParticipationService;
import ru.matcher.services.service.IProjectService;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация интерфейса ProjectService.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final ProjectRepository projectRepository;
    private final ProjectStruct projectStruct;
    private final ProjectParticipationRepository projectParticipationRepository;
    private final ProjectParticipationStruct projectParticipationStruct;
    private final OrganizationStruct organizationStruct;
    private final UserOrganizationRepository userOrganizationRepository;
    private final OrganizationRepository organizationRepository;
    private final PictureRepository pictureRepository;
    private final IProjectParticipationService projectParticipationService;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,
                              ProjectStruct projectStruct, OrganizationStruct organizationStruct,
                              UserOrganizationRepository userOrganizationRepository, OrganizationRepository organizationRepository,
                              PictureRepository pictureRepository, ProjectParticipationServiceImpl projectParticipationService,
                              ProjectParticipationRepository projectParticipationRepository,
                              ProjectParticipationStruct projectParticipationStruct) {

        this.projectRepository = projectRepository;
        this.projectStruct = projectStruct;
        this.organizationStruct = organizationStruct;
        this.userOrganizationRepository = userOrganizationRepository;
        this.organizationRepository = organizationRepository;
        this.pictureRepository = pictureRepository;
        this.projectParticipationService = projectParticipationService;
        this.projectParticipationRepository = projectParticipationRepository;
        this.projectParticipationStruct = projectParticipationStruct;
    }

    @Override
    @Transactional
    public ProjectDto create(ProjectCreateDto projectCreateDto) {
        UserOrganization userOrganization = userOrganizationRepository.findByIdUser(projectCreateDto.getUserId()).get(0);
        OrganizationDto organizationDto = organizationStruct.toDto(organizationRepository.findById(userOrganization.getId().getOrganization()).orElse(null));
        projectCreateDto.setOrganizationId(organizationDto.getId());
        Project project = projectStruct.fromDto(projectCreateDto);
        Integer pictureId = projectCreateDto.getPictureId();
        if (pictureId != null) {
            project.setPicture(pictureRepository.findById(pictureId).orElse(null));
        }
        project.setCurrentLifecycle(projectCreateDto.getLifecycle().substring(0,projectCreateDto.getLifecycle().indexOf(",")));
        project.setActive(true);
        projectRepository.save(project);

        final var projectParticipationBuilder = ProjectParticipationDto.Builder.aProjectParticipationDto()
                .withProjectId(project.getId())
                .withUserId(projectCreateDto.getUserId())
                .withStartDate(LocalDate.now())
                .withUserRole("Создатель")
                .withIsAdmin(true);
        logger.info("User(id = {}) create project(id = {})", projectCreateDto.getUserId(), project.getId());
        projectParticipationService.create(projectParticipationBuilder.build());

        return projectStruct.toDto(project);
    }

    @Override
    @Transactional
    public ProjectDto update(Integer projectId, ProjectDto projectDtoToUpdate) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        project.setName(projectDtoToUpdate.getName());
        project.setDescription(projectDtoToUpdate.getDescription());
        Organization organization = organizationRepository.findOrganizationById(projectDtoToUpdate.getOrganizationId());
        project.setOrganization(organization);
        project.setPicture(projectStruct.fromDto(projectDtoToUpdate).getPicture());
        projectRepository.save(project);
        return projectStruct.toDto(project);
    }

    @Override
    public void remove(int projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public List<ProjectDto> getProjects() {
        List<ProjectDto> projectDtos = projectStruct.toDto(projectRepository.findAll());
        return projectDtos;
    }

    @Override
    public ProjectDto findById(int projectId) {
        return projectStruct.toDto(projectRepository.findById(projectId).orElse(null));
    }

    @Override
    public List<ProjectDto> getProjectsByUserId(int userId) {
        List<ProjectParticipationDto> projectParticipations = projectParticipationStruct.toDto(projectParticipationRepository.findByUserId(userId));
        List<ProjectDto> projectDtos = new ArrayList<>();
        //fixme needed fix n+1 problem
        for (ProjectParticipationDto projectParticipation : projectParticipations) {
            projectDtos.add(projectStruct.toDto(projectRepository.findById(projectParticipation.getProjectId()).orElse(null)));
        }
        return projectDtos;
    }

    @Override
    public List<ProjectDto> getProjectsByOrganizationId(int orgId) {
        return projectRepository.findProjectByOrganization(orgId)
                .stream()
                .map(projectStruct::toDto)
                .collect(Collectors.toList());
    }
}
