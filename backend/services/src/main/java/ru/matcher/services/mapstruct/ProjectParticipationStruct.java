package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import ru.matcher.data.model.ProjectParticipation;
import ru.matcher.services.dto.ProjectParticipationDto;

import java.util.List;

@Mapper
public interface ProjectParticipationStruct {

    ProjectParticipationDto toDto(ProjectParticipation projectParticipation);

    ProjectParticipation fromDto(ProjectParticipationDto projectParticipationDto);

    List<ProjectParticipationDto> toDto(List<ProjectParticipation> projectParticipations);

    List<ProjectParticipation> fromDto(List<ProjectParticipationDto> projectParticipationDtos);
}
