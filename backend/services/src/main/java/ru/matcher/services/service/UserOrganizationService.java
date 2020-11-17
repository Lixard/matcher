package ru.matcher.services.service;

import ru.matcher.data.model.embedded.UserOrganisationEmbeddedId;
import ru.matcher.services.dto.UserOrganizationDto;

import java.util.List;

/**
 * Интерфейс сервиса для организаций пользователя.
 *
 * @author Николай Евсюков
 */
public interface UserOrganizationService {

    /**
     * Добавление или обновление UserOrganization в БД.
     *
     * @param userOrganizationDto объект класса UserOrganizationDto
     * @return объект класса UserOrganizationDto
     */
    UserOrganizationDto createOrUpdate(UserOrganizationDto userOrganizationDto);

    /**
     * Удаление UserOrganization из БД.
     *
     * @param userOrganizationId идентификатор UserOrganization
     */
    void remove(UserOrganisationEmbeddedId userOrganizationId);

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
    UserOrganizationDto findById(UserOrganisationEmbeddedId userOrganizationId);
}
