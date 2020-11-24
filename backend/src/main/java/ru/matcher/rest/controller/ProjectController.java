package ru.matcher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.matcher.services.dto.ProjectDto;
import ru.matcher.services.service.IProjectService;

import java.util.List;

/**
 * Контроллер для проектов.
 *
 * @author Николай Евсюков
 */
@RestController
@RequestMapping(
        path = "/project",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ProjectController {

    private final IProjectService projectService;

    @Autowired
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Добавление проекта.
     *
     * @param projectDto проект для добавления
     * @return добавленный проект
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ProjectDto createProject(@RequestBody ProjectDto projectDto) {
        return projectService.create(projectDto);
    }

    /**
     * Обновление проекта.
     *
     * @param id         идентификатор проекта
     * @param projectDto новый проект
     * @return обновлённый проект
     */
    @PutMapping("/{id}")
    ProjectDto updateProject(@PathVariable int id,
                             @RequestBody ProjectDto projectDto) {
        projectDto.setId(id);
        return projectService.update(projectDto);
    }

    /**
     * Удаленеи проекта.
     *
     * @param id идентификатор проекта
     */
    @DeleteMapping("/{id}")
    void deleteProject(@PathVariable int id) {
        projectService.remove(id);
    }

    /**
     * Список всех проектов.
     *
     * @return список всех проектов
     */
    @GetMapping
    List<ProjectDto> getProjects() {
        return projectService.getProjects();
    }

    /**
     * Поиск проекта по ID.
     *
     * @param id идентификатор проекта
     * @return найденный проект
     */
    @GetMapping("/{id}")
    ProjectDto getProjectById(@PathVariable int id) {
        return projectService.findById(id);
    }
}
