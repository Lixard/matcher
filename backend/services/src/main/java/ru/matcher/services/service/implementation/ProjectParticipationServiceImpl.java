package ru.matcher.services.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.ProjectParticipation;
import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;
import ru.matcher.data.repository.ProjectParticipationRepository;
import ru.matcher.security.model.ICurrentUser;
import ru.matcher.services.dto.OrganizationDto;
import ru.matcher.services.dto.ProjectParticipationDto;
import ru.matcher.services.dto.UserDto;
import ru.matcher.services.dto.get.UserProjectGetDto;
import ru.matcher.services.mapstruct.ProjectParticipationStruct;
import ru.matcher.services.service.IOrganizationService;
import ru.matcher.services.service.IProjectParticipationService;
import ru.matcher.services.service.IUserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Реализация интерфейса ProjectParticipationService.
 *
 * @author Николай Евсюков
 */
@Service
public class ProjectParticipationServiceImpl implements IProjectParticipationService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectParticipationServiceImpl.class);
    private final ICurrentUser currentUser;
    private final ProjectParticipationRepository projectParticipationRepository;
    private final ProjectParticipationStruct projectParticipationStruct;
    private final IUserService userService;
    private final IOrganizationService organizationService;

    @Autowired
    public ProjectParticipationServiceImpl(ICurrentUser currentUser, ProjectParticipationRepository projectParticipationRepository,
                                           ProjectParticipationStruct projectParticipationStruct,
                                           IUserService userService, IOrganizationService organizationService) {
        this.currentUser = currentUser;
        this.projectParticipationRepository = projectParticipationRepository;
        this.projectParticipationStruct = projectParticipationStruct;
        this.userService = userService;
        this.organizationService = organizationService;
    }

    @Override
    @Transactional
    public ProjectParticipationDto create(ProjectParticipationDto projectParticipationDto) {
        ProjectParticipation projectParticipation = projectParticipationStruct.fromDto(projectParticipationDto);
        projectParticipationRepository.save(projectParticipation);
        return projectParticipationStruct.toDto(projectParticipation);
    }

    @Override
    @Transactional
    public ProjectParticipationDto update(ProjectParticipationDto projectParticipationDto) {
        ProjectParticipation projectParticipation = projectParticipationStruct.fromDto(projectParticipationDto);
        projectParticipationRepository.save(projectParticipation);
        return projectParticipationStruct.toDto(projectParticipation);
    }

    @Override
    @Transactional
    public void remove(Integer projectId, Integer userId) {
        ProjectUserEmbeddedId projectParticipationId = new ProjectUserEmbeddedId();
        projectParticipationId.setProject(projectId);
        projectParticipationId.setUser(userId);
        projectParticipationRepository.deleteById(projectParticipationId);
    }

    @Override
    @Transactional
    public void removeAdmin(Integer projectId, Integer userId) {
        ProjectParticipation projectParticipation = projectParticipationRepository.findByProjectIdAndUserId(projectId, userId);
        projectParticipation.setAdmin(false);
        projectParticipationRepository.save(projectParticipation);
    }

    @Override
    public List<ProjectParticipationDto> getProjectParticipations() {
        return projectParticipationStruct.toDto(projectParticipationRepository.findAll());
    }

    @Override
    public ProjectParticipationDto findById(ProjectUserEmbeddedId projectParticipationId) {
        return projectParticipationStruct.toDto(projectParticipationRepository.findById(projectParticipationId).orElse(null));
    }

    @Override
    public List<UserProjectGetDto> getParticipationsByIdProject(Integer projectId) {
        List<ProjectParticipationDto> projectParticipations = projectParticipationStruct.toDto(projectParticipationRepository.findByProjectId(projectId));
        List<UserProjectGetDto> userProjectGetDtos = new ArrayList<>();
        for (ProjectParticipationDto projectParticipation : projectParticipations) {
            UserDto userDto = userService.findById(projectParticipation.getUserId());
            final var builder = UserProjectGetDto.Builder.anUserProjectGetDto()
                    .withId(userDto.getId())
                    .withFirstName(userDto.getFirstName())
                    .withLastName(userDto.getLastName())
                    .withIsAdmin(projectParticipation.isAdmin())
                    .withUserRole(projectParticipation.getUserRole());

            userProjectGetDtos.add(builder.build());
        }
        return userProjectGetDtos;
    }

    @Override
    public void setEndDateIfCompleteProject(Integer projectId) {
        List<ProjectParticipationDto> projectParticipations = projectParticipationStruct.toDto(projectParticipationRepository.findByProjectId(projectId));
        for (ProjectParticipationDto projectParticipation : projectParticipations) {
            projectParticipation.setEndDate(LocalDate.now());
            projectParticipationRepository.save(projectParticipationStruct.fromDto(projectParticipation));
        }
    }

    @Override
    public void admin(Integer projectId, Integer userId) {
        ProjectUserEmbeddedId projectUserEmbeddedId = new ProjectUserEmbeddedId();
        projectUserEmbeddedId.setProject(projectId);
        projectUserEmbeddedId.setUser(userId);
        ProjectParticipationDto projectParticipationDto = findById(projectUserEmbeddedId);
        projectParticipationDto.setAdmin(true);
        update(projectParticipationDto);
    }

    @Override
    public List<OrganizationDto> getAdminOrganizations(Integer projectId) {
        List<ProjectParticipationDto> projectParticipations = projectParticipationStruct.toDto(projectParticipationRepository.findByProjectId(projectId));
        HashMap<Integer, OrganizationDto> organizationDtosMap = new HashMap<>();
        for (ProjectParticipationDto projectParticipation : projectParticipations) {
            if (projectParticipation.isAdmin()) {
                for (OrganizationDto organizationDto : organizationService.getOrganizationsByUser(projectParticipation.getUserId())) {
                    organizationDtosMap.putIfAbsent(organizationDto.getId(), organizationDto);
                }
            }
        }
        return new ArrayList<>(organizationDtosMap.values());
    }

    @Override
    @Transactional
    public void updateUserRoleByProjectIdAndUserId(int projectId, int userId, UserProjectGetDto userProjectDto) {
        int adminId = currentUser.getId();
        if (!projectParticipationRepository.isAdmin(projectId, adminId)) {
            throw new IllegalStateException(String.format("User(id = %d) has no admin rights", adminId));
        }
        ProjectParticipation projectParticipation = projectParticipationRepository
                .findByProjectIdAndUserId(projectId, userId);
        String oldRole = projectParticipation.getUserRole();
                projectParticipation.setUserRole(userProjectDto.getUserRole());
        projectParticipationRepository.save(projectParticipation);
        logger.info("Admin(id = {}) changed user's(id = {}) role in the project(id = {}) from '{}' to '{}'", adminId,
                userId, projectId, oldRole, projectParticipation.getUserRole());
    }
}
