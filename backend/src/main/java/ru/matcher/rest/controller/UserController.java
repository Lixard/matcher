package ru.matcher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
        path = "/user",
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
    UserDto updateUser(@PathVariable int id,
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
    void deleteUser(@PathVariable int id) {
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
    UserDto getUserById(@PathVariable int id) {
        return userService.findById(id);
    }
}
