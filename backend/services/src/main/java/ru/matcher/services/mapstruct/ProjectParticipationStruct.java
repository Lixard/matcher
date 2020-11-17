package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
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
    ProjectParticipationDto toDto(ProjectParticipation projectParticipation);

    /**
     * Превражение ProjectParticipationDto в ProjectParticipation.
     *
     * @param projectParticipationDto объект класса ProjectParticipationDto
     * @return объект класса ProjectParticipation
     */
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
