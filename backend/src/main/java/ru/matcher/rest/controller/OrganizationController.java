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
import ru.matcher.services.dto.UserDto;
import ru.matcher.services.service.IOrganizationService;
import ru.matcher.services.service.IUserOrganizationService;

import java.util.List;

/**
 * Контроллер для организаций.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
 */
@RestController
@RequestMapping(
        path = "/organizations",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class OrganizationController {

    private final IOrganizationService organizationService;
    private final IUserOrganizationService userOrganizationService;

    @Autowired
    public OrganizationController(IOrganizationService organizationService,
                                  IUserOrganizationService userOrganizationService) {
        this.organizationService = organizationService;
        this.userOrganizationService = userOrganizationService;
    }

    /**
     * Добавление организагии.
     *
     * @param organizationDto организация для добавления
     * @return добавленная организация
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrganizationDto createOrganization(@RequestBody OrganizationDto organizationDto) {
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
    public OrganizationDto updateOrganization(@PathVariable Integer id,
                                              @RequestBody OrganizationDto organizationDto) {
        organizationDto.setId(id);
        return organizationService.update(organizationDto);
    }

    /**
     * Удаление организации.
     *
     * @param id идентификатор организации
     */
    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Integer id) {
        organizationService.remove(id);
    }

    /**
     * Список всех организаций.
     *
     * @return список всех организаций
     */
    @GetMapping
    public List<OrganizationDto> getOrganizations() {
        return organizationService.getOrganizations();
    }

    /**
     * Поиск организации по ID.
     *
     * @param id идентификатор организации
     * @return найденная организация
     */
    @GetMapping("/{id}")
    public OrganizationDto getOrganizationById(@PathVariable Integer id) {
        return organizationService.findById(id);
    }

    @GetMapping("/type/{id}")
    public List<OrganizationDto> findByOrganizationType(@PathVariable Integer id) {
        return organizationService.findByOrganizationType(id);
    }

    @GetMapping("/user/{userId}")
    public List<OrganizationDto> findOrganizationsByUserId(@PathVariable int userId) {
        return organizationService.getOrganizationsByUser(userId);
    }

    @GetMapping("/admin/{userId}/{orgId}")
    public boolean isAdmin(@PathVariable("userId") Integer userId, @PathVariable("orgId") Integer orgId) {
        return userOrganizationService.isAdmin(userId, orgId);
    }

    @GetMapping("/{orgId}/users")
    public List<UserDto> findUsersByOrganizationId(@PathVariable Integer orgId) {
        return organizationService.getUsersByOrganization(orgId);
    }
}
