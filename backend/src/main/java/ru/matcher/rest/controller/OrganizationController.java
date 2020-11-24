package ru.matcher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.matcher.services.dto.OrganizationDto;
import ru.matcher.services.service.IOrganizationService;

import java.util.List;

/**
 * Контроллер для организаций.
 *
 * @author Николай Евсюков
 */
@RestController
@RequestMapping(
        path = "/organization",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class OrganizationController {

    private final IOrganizationService organizationService;

    @Autowired
    public OrganizationController(IOrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Добавление организагии.
     *
     * @param organizationDto организация для добавления
     * @return добавленная организация
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    OrganizationDto createOrganization(@RequestBody OrganizationDto organizationDto) {
        return organizationService.create(organizationDto);
    }

    /**
     * Обновление организации.
     *
     * @param id              идентификатор организации
     * @param organizationDto новая организация
     * @return обновлённая организация
     */
    @PutMapping("/{id}")
    OrganizationDto updateOrganization(@PathVariable int id,
                                       @RequestBody OrganizationDto organizationDto) {
        organizationDto.setId(id);
        return organizationService.update(organizationDto);
    }

    /**
     * Удаленеи организации.
     *
     * @param id идентификатор организации
     */
    @DeleteMapping("/{id}")
    void deleteOrganization(@PathVariable int id) {
        organizationService.remove(id);
    }

    /**
     * Список всех организаций.
     *
     * @return список всех организаций
     */
    @GetMapping
    List<OrganizationDto> getOrganizations() {
        return organizationService.getOrganizations();
    }

    /**
     * Поиск организации по ID.
     *
     * @param id идентификатор организации
     * @return найденная организация
     */
    @GetMapping("/{id}")
    OrganizationDto getOrganizationById(@PathVariable int id) {
        return organizationService.findById(id);
    }
}
