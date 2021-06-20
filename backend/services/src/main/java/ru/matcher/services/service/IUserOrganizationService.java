package ru.matcher.services.service;

import ru.matcher.data.model.embedded.UserOrganizationEmbeddedId;
import ru.matcher.services.dto.UserOrganizationDto;
import ru.matcher.services.dto.update.UserOrganizationUpdate;

import java.util.List;

/**
 * Интерфейс сервиса для организаций пользователя.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
 */
public interface IUserOrganizationService {

    /**
     * Добавление UserOrganization в БД.
     *
     * @param userOrganizationDto объект класса UserOrganizationDto
     * @return объект класса UserOrganizationDto
     */
    UserOrganizationDto create(UserOrganizationDto userOrganizationDto);

    /**
     * Обновление UserOrganization в БД.
     *
     * @param userOrganizationUpdate объект класса UserOrganizationUpdate
     * @return объект класса UserOrganizationDto
     */
    UserOrganizationDto update(UserOrganizationUpdate userOrganizationUpdate);

    /**
     * Удаление UserOrganization из БД.
     *
     * @param userOrganizationId идентификатор UserOrganization
     */
    void remove(UserOrganizationEmbeddedId userOrganizationId);

    /**
     * Возвращяет список UserOrganizationDto из БД.
     *
     * @return список UserOrganizationDto
     */
    List<UserOrganizationDto> getUserOrganizations();

    /**
     * Поиск UserOrganization по id.
     *
     * @param userOrganizationId идентификатор UserOrganization
     * @return найденный объект класса UserOrganizationDto
     */
    UserOrganizationDto findById(UserOrganizationEmbeddedId userOrganizationId);

    /**
     * Проверка является ли пользователь администратором организации
     * @param userId id пользователя
     * @param orgId id организации
     * @return является ли пользователь администратором организации
     */
    boolean isAdmin(Integer userId, Integer orgId);
}
