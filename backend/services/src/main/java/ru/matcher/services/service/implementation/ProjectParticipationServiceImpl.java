package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.ProjectParticipation;
import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;
import ru.matcher.data.repository.ProjectParticipationRepository;
import ru.matcher.services.dto.ProjectParticipationDto;
import ru.matcher.services.mapstruct.ProjectParticipationStruct;
import ru.matcher.services.service.IProjectParticipationService;

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

    @Autowired
    public ProjectParticipationServiceImpl(ProjectParticipationRepository projectParticipationRepository,
                                           ProjectParticipationStruct projectParticipationStruct) {
        this.projectParticipationRepository = projectParticipationRepository;
        this.projectParticipationStruct = projectParticipationStruct;
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
}
