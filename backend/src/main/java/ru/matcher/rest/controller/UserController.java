package ru.matcher.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import ru.matcher.services.dto.UserDto;
import ru.matcher.services.dto.UserOrganizationDto;
import ru.matcher.services.dto.create.UserCreateDto;
import ru.matcher.services.dto.update.UserOrganizationUpdate;
import ru.matcher.services.service.IOrganizationService;
import ru.matcher.services.service.IUserOrganizationService;
import ru.matcher.services.service.IUserService;

import java.util.List;

/**
 * Контроллер для пользователя.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
 */
@RestController
@RequestMapping(
        path = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final IUserService userService;
    private final IUserOrganizationService userOrganizationService;

    @Autowired
    public UserController(IUserService userService, IUserOrganizationService userOrganizationService, IOrganizationService organizationService) {
        this.userService = userService;
        this.userOrganizationService = userOrganizationService;
    }

    /**
     * Добавление пользователя.
     *
     * @param userDto пользователь для добавления
     * @return добавленный пользователь
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserCreateDto userDto) {
        logger.info("User to create: {}", userDto);
        return userService.create(userDto);
    }

    /**
     * Обновление пользователя.
     *
     * @param id      идентификатор пользователя
     * @param userDto новый пользователь
     * @return обновлённый пользователь
     */
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Integer id,
                              @RequestBody UserDto userDto) {
        userDto.setId(id);
        logger.info("User to update: {}", userDto);
        return userService.update(userDto);
    }

    /**
     * Удаление пользователя.
     *
     * @param id идентификатор пользователя
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.remove(id);
    }

    /**
     * Список всех пользователей.
     *
     * @return список всех пользователей
     */
    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    /**
     * Поиск пользователя по ID.
     *
     * @param id идентификатор пользователей
     * @return найденный пользователь
     */
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/organization")
    public UserOrganizationDto updateUserOrganization(@RequestBody UserOrganizationUpdate userOrganizationUpdate) {
        return userOrganizationService.update(userOrganizationUpdate);
    }

}
