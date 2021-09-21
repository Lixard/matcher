package ru.matcher.services.service;

import ru.matcher.services.dto.ProjectDto;
import ru.matcher.services.dto.create.ProjectCreateDto;

import java.util.List;

/**
 * Интерфейс сервиса для проектов.
 *
 * @author Николай Евсюков
 */
public interface IProjectService {

    /**
     * Добавление Project в БД.
     *
     * @param projectCreateDto объект класса ProjectCreateDto
     * @return объект класса ProjectDto
     */
    ProjectDto create(ProjectCreateDto projectCreateDto);

    /**
     * Обновление Project в БД.
     *
     * @param projectDto объект класса ProjectDto
     * @return объект класса ProjectDto
     */
    ProjectDto update(ProjectDto projectDto);

    /**
     * Удаление Project из БД.
     *
     * @param projectId идентификатор Project
     */
    void remove(int projectId);

    /**
     * Возвращяет список ProjectDto из БД.
     *
     * @return список ProjectDto
     */
    List<ProjectDto> getProjects();

    /**
     * Поиск Project по id.
     *
     * @param projectId идентификатор Project
     * @return найденный объект класса ProjectDto
     */
    ProjectDto findById(int projectId);
}
