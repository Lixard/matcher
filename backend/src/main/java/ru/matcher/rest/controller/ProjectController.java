package ru.matcher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        path = "/projects",
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
    public ProjectDto createProject(@RequestBody ProjectDto projectDto) {
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
    public ProjectDto updateProject(@PathVariable Integer id,
                                    @RequestBody ProjectDto projectDto) {
        projectDto.setId(id);
        return projectService.update(projectDto);
    }

    /**
     * Удаление проекта.
     *
     * @param id идентификатор проекта
     */
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Integer id) {
        projectService.remove(id);
    }

    /**
     * Список всех проектов.
     *
     * @return список всех проектов
     */
    @GetMapping
    public List<ProjectDto> getProjects() {
        return projectService.getProjects();
    }

    /**
     * Поиск проекта по ID.
     *
     * @param id идентификатор проекта
     * @return найденный проект
     */
    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable Integer id) {
        return projectService.findById(id);
    }
}
