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
import ru.matcher.services.dto.UserDto;
import ru.matcher.services.service.IUserService;

import java.util.List;

/**
 * Контроллер для пользователя.
 *
 * @author Николай Евсюков
 */
@RestController
@RequestMapping(
        path = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Добавление пользователя.
     *
     * @param userDto пользователь для добавления
     * @return добавленный пользователь
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDto createUser(@RequestBody UserDto userDto) {
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
    UserDto updateUser(@PathVariable Integer id,
                       @RequestBody UserDto userDto) {
        userDto.setId(id);
        return userService.update(userDto);
    }

    /**
     * Удаление пользователя.
     *
     * @param id идентификатор пользователеля
     */
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Integer id) {
        userService.remove(id);
    }

    /**
     * Список всех пользователей.
     *
     * @return список всех пользователей
     */
    @GetMapping
    List<UserDto> getUsers() {
        return userService.getUsers();
    }

    /**
     * Поиск пользователя по ID.
     *
     * @param id идентификатор пользователей
     * @return найденный пользователь
     */
    @GetMapping("/{id}")
    UserDto getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }
}
