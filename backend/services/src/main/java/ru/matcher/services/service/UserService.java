package ru.matcher.services.service;

import ru.matcher.services.dto.UserDto;

import java.util.List;

/**
 * Интерфейс сервиса для пользователя.
 *
 * @author Николай Евсюков
 */
public interface UserService {

    /**
     * Добавление или обновление User в БД.
     *
     * @param userDto объект класса UserDto
     * @return объект класса UserDto
     */
    UserDto createOrUpdate(UserDto userDto);

    /**
     * Удаление User из БД.
     *
     * @param userId идентификатор User
     */
    void remove(int userId);

    /**
     * Возвращяет список UserDto из БД.
     *
     * @return список UserDto
     */
    List<UserDto> getUsers();

    /**
     * Поиск User по id.
     *
     * @param userId идентификатор User
     * @return найденный объект класса UserDto
     */
    UserDto findById(int userId);
}
