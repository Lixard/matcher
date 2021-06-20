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
    @Mapping(target = "userId", source = "id.user")
    @Mapping(target = "projectId", source = "id.project")
    ProjectParticipationDto toDto(ProjectParticipation projectParticipation);

    /**
     * Превражение ProjectParticipationDto в ProjectParticipation.
     *
     * @param projectParticipationDto объект класса ProjectParticipationDto
     * @return объект класса ProjectParticipation
     */
    @Mapping(target = "id.user", source = "userId")
    @Mapping(target = "id.project", source = "projectId")
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
