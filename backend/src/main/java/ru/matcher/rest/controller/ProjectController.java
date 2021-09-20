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
import ru.matcher.services.dto.OrganizationDto;
import ru.matcher.services.dto.ProjectDto;
import ru.matcher.services.dto.create.ProjectCreateDto;
import ru.matcher.services.dto.get.UserProjectGetDto;
import ru.matcher.services.service.IProjectParticipationService;
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
    private final IProjectParticipationService projectParticipationService;

    @Autowired
    public ProjectController(IProjectService projectService, IProjectParticipationService projectParticipationService) {
        this.projectService = projectService;
        this.projectParticipationService = projectParticipationService;
    }

    /**
     * Добавление проекта.
     *
     * @param projectCreateDto проект для добавления
     * @return добавленный проект
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProjectDto createProject(@RequestBody ProjectCreateDto projectCreateDto) {
        return projectService.create(projectCreateDto);
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


    @GetMapping("/participants/{projectId}")
    public List<UserProjectGetDto> getParticipantsOfProject(@PathVariable Integer projectId) {
        return projectParticipationService.getParticipationsByIdProject(projectId);
    }

    @GetMapping("/complete/participants/{projectId}")
    public void setEndDateIfCompleteProject(@PathVariable Integer projectId) {
        projectParticipationService.setEndDateIfCompleteProject(projectId);
    }

    @GetMapping("/{projectId}/subscribe")
    public void subscribe(@PathVariable Integer projectId) {
        projectParticipationService.subscribe(projectId);
    }

    @GetMapping("/{projectId}/admin/{userId}")
    public void admin(@PathVariable Integer projectId, @PathVariable Integer userId) {
        projectParticipationService.admin(projectId, userId);
    }

    @GetMapping("/{projectId}/organizations/admin")
    public List<OrganizationDto> getAdminOrganizations(@PathVariable Integer projectId) {
        return projectParticipationService.getAdminOrganizations(projectId);
    }

    @DeleteMapping("/{projectId}/{userId}")
    public void remove (@PathVariable Integer projectId, @PathVariable Integer userId) {
        projectParticipationService.remove(projectId, userId);
    }
}
