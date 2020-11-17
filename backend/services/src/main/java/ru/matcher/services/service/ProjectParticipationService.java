package ru.matcher.services.service;

import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;
import ru.matcher.services.dto.ProjectParticipationDto;

import java.util.List;

public interface ProjectParticipationService {

    ProjectParticipationDto createOrUpdate(ProjectParticipationDto projectParticipationDto);

    void remove(ProjectUserEmbeddedId projectParticipationId);

    List<ProjectParticipationDto> getProjectParticipations();

    ProjectParticipationDto findById(ProjectUserEmbeddedId projectParticipationId);
}
