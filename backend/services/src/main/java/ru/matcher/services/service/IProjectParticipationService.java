package ru.matcher.services.service;

import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;
import ru.matcher.services.dto.OrganizationDto;
import ru.matcher.services.dto.ProjectParticipationDto;
import ru.matcher.services.dto.get.UserProjectGetDto;

import java.util.List;

/**
 * Интерфейс сервиса для пользователей учавствовавших в проектах.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
 */
public interface IProjectParticipationService {

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
     * @param projectId идентификатор Project
     * @param userId идентификатор User
     */
    void remove(Integer projectId, Integer userId);

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


    List<UserProjectGetDto> getParticipationsByIdProject(Integer projectId);

    void setEndDateIfCompleteProject(Integer projectId);

    void subscribe(Integer projectId);

    void admin(Integer projectId, Integer userId);

    List<OrganizationDto> getAdminOrganizations(Integer projectId);

    void updateUserRoleByProjectIdAndUserId(int projectId, int userId, UserProjectGetDto userProjectDto);
}
