package ru.matcher.services.service.implementation;

import org.springframework.stereotype.Service;
import ru.matcher.data.model.ProjectParticipation;
import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;
import ru.matcher.data.repository.ProjectParticipationRepository;
import ru.matcher.services.dto.ProjectParticipationDto;
import ru.matcher.services.mapstruct.ProjectParticipationStruct;
import ru.matcher.services.service.ProjectParticipationService;

import java.util.List;

/**
 * Реализация интерфейса ProjectParticipationService.
 *
 * @author Николай Евсюков
 */
@Service
public class ProjectParticipationServiceImpl implements ProjectParticipationService {

    private final ProjectParticipationRepository projectParticipationRepository;
    private final ProjectParticipationStruct projectParticipationStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public ProjectParticipationServiceImpl(ProjectParticipationRepository projectParticipationRepository,
                                           ProjectParticipationStruct projectParticipationStruct) {
        this.projectParticipationRepository = projectParticipationRepository;
        this.projectParticipationStruct = projectParticipationStruct;
    }

    @Override
    public ProjectParticipationDto createOrUpdate(ProjectParticipationDto projectParticipationDto) {
        ProjectParticipation projectParticipation = projectParticipationStruct.fromDto(projectParticipationDto);
        projectParticipationRepository.save(projectParticipation);
        return projectParticipationStruct.toDto(projectParticipation);
    }

    @Override
    public void remove(ProjectUserEmbeddedId projectParticipationId) {
        projectParticipationRepository.deleteById(projectParticipationId);
    }

    @Override
    public List<ProjectParticipationDto> getProjectParticipations() {
        return projectParticipationStruct.toDto(projectParticipationRepository.findAll());
    }

    @Override
    public ProjectParticipationDto findById(ProjectUserEmbeddedId projectParticipationId) {
        return projectParticipationStruct.toDto(projectParticipationRepository.findById(projectParticipationId).orElseThrow());
    }
}
