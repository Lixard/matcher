package ru.matcher.services.service;

import ru.matcher.services.dto.OrganizationTypeDto;

import java.util.List;

/**
 * Интерфейс сервиса для типа организации.
 *
 * @author Николай Евсюков
 */
public interface OrganizationTypeService {

    /**
     * Добавление или обновление OrganizationType в БД.
     *
     * @param organizationTypeDto объект класса OrganizationTypeDto
     * @return объект класса OrganizationTypeDto
     */
    OrganizationTypeDto createOrUpdate(OrganizationTypeDto organizationTypeDto);

    /**
     * Удаление OrganizationType из БД.
     *
     * @param organizationTypeId идентификатор OrganizationType
     */
    void remove(int organizationTypeId);

    /**
     * Возвращяет список OrganizationTypeDto из БД.
     *
     * @return список OrganizationTypeDto
     */
    List<OrganizationTypeDto> getOrganizationTypes();

    /**
     * Поиск OrganizationType по id.
     *
     * @param organizationTypeId идентификатор OrganizationType
     * @return найденный объект класса OrganizationTypeDto
     */
    OrganizationTypeDto findById(int organizationTypeId);
}