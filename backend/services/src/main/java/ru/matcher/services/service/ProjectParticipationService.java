package ru.matcher.services.service;

import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;
import ru.matcher.services.dto.ProjectParticipationDto;

import java.util.List;

/**
 * Интерфейс сервиса для пользователей учавствовавших в проектах.
 *
 * @author Николай Евсюков
 */
public interface ProjectParticipationService {

    /**
     * Добавление ProjectParticipation в БД.
     *
     * @param projectParticipationDto объект класса ProjectParticipationDto
     * @return объект класса ProjectParticipationDto
     */
    ProjectParticipationDto create(ProjectParticipationDto projectParticipationDto);

    /**
     * Обновление ProjectParticipation в БД.
     *
     * @param projectParticipationDto объект класса ProjectParticipationDto
     * @return объект класса ProjectParticipationDto
     */
    ProjectParticipationDto update(ProjectParticipationDto projectParticipationDto);

    /**
     * Удаление ProjectParticipation из БД.
     *
     * @param projectParticipationId идентификатор ProjectParticipation
     */
    void remove(ProjectUserEmbeddedId projectParticipationId);

    /**
     * Возвращяет список ProjectParticipationDto из БД.
     *
     * @return список ProjectParticipationDto
     */
    List<ProjectParticipationDto> getProjectParticipations();

    /**
     * Поиск ProjectParticipation по id.
     *
     * @param projectParticipationId идентификатор ProjectParticipation
     * @return найденный объект класса ProjectParticipationDto
     */
    ProjectParticipationDto findById(ProjectUserEmbeddedId projectParticipationId);
}
