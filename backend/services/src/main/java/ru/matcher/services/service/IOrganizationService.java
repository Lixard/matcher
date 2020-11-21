package ru.matcher.services.service;

import ru.matcher.services.dto.OrganizationDto;

import java.util.List;

/**
 * Интерфейс сервиса для организации.
 *
 * @author Николай Евсюков
 */
public interface IOrganizationService {

    /**
     * Добавление Organization в БД.
     *
     * @param organizationDto объект класса OrganizationDto
     * @return объект класса OrganizationDto
     */
    OrganizationDto create(OrganizationDto organizationDto);

    /**
     * Обновление Organization в БД.
     *
     * @param organizationDto объект класса OrganizationDto
     * @return объект класса OrganizationDto
     */
    OrganizationDto update(OrganizationDto organizationDto);

    /**
     * Удаление Organization из БД.
     *
     * @param organizationId идентификатор Organization
     */
    void remove(int organizationId);

    /**
     * Возвращяет список OrganizationDto из БД.
     *
     * @return список OrganizationDto
     */
    List<OrganizationDto> getOrganizations();

    /**
     * Поиск Organization по id.
     *
     * @param organizationId идентификатор Organization
     * @return найденный объект класса OrganizationDto
     */
    OrganizationDto findById(int organizationId);
}
