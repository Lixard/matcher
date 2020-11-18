package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.matcher.data.model.ProjectParticipation;
import ru.matcher.services.dto.ProjectParticipationDto;

import java.util.List;

/**
 * Маппер для пользователей учавствовавших в проектах.
 *
 * @author Николай Евсюков
 */
@Mapper
public interface ProjectParticipationStruct {

    /**
     * Превращение ProjectParticipation в ProjectParticipationDto.
     *
     * @param projectParticipation объект класса ProjectParticipation
     * @return объект класса ProjectParticipationDto
     */
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "projectId", source = "project.id")
    ProjectParticipationDto toDto(ProjectParticipation projectParticipation);

    /**
     * Превражение ProjectParticipationDto в ProjectParticipation.
     *
     * @param projectParticipationDto объект класса ProjectParticipationDto
     * @return объект класса ProjectParticipation
     */
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "project.id", source = "projectId")
    ProjectParticipation fromDto(ProjectParticipationDto projectParticipationDto);

    /**
     * Превращение списка ProjectParticipation в список ProjectParticipationDto.
     *
     * @param projectParticipations список ProjectParticipation
     * @return список ProjectParticipationDto
     */
    List<ProjectParticipationDto> toDto(List<ProjectParticipation> projectParticipations);

    /**
     * Превращение списка ProjectParticipationDto в список ProjectParticipation.
     *
     * @param projectParticipationDtos список ProjectParticipationDto
     * @return список ProjectParticipation
     */
    List<ProjectParticipation> fromDto(List<ProjectParticipationDto> projectParticipationDtos);
}
