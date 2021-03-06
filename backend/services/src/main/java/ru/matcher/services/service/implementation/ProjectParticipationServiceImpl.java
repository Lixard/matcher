package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.ProjectParticipation;
import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;
import ru.matcher.data.repository.ProjectParticipationRepository;
import ru.matcher.services.dto.ProjectParticipationDto;
import ru.matcher.services.dto.UserDto;
import ru.matcher.services.dto.get.UserProjectGetDto;
import ru.matcher.services.mapstruct.ProjectParticipationStruct;
import ru.matcher.services.mapstruct.UserStruct;
import ru.matcher.services.service.IProjectParticipationService;
import ru.matcher.services.service.IUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса ProjectParticipationService.
 *
 * @author Николай Евсюков
 */
@Service
public class ProjectParticipationServiceImpl implements IProjectParticipationService {

    private final ProjectParticipationRepository projectParticipationRepository;
    private final ProjectParticipationStruct projectParticipationStruct;
    private final IUserService userService;

    @Autowired
    public ProjectParticipationServiceImpl(ProjectParticipationRepository projectParticipationRepository,
                                           ProjectParticipationStruct projectParticipationStruct,
                                           IUserService userService) {
        this.projectParticipationRepository = projectParticipationRepository;
        this.projectParticipationStruct = projectParticipationStruct;
        this.userService = userService;
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
    public void remove(ProjectUserEmbeddedId projectParticipationId) {
        projectParticipationRepository.deleteById(projectParticipationId);
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
                    .withIsAdmin(projectParticipation.isAdmin());

            userProjectGetDtos.add(builder.build());
        }
        return userProjectGetDtos;
    }
}
