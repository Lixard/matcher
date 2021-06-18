package ru.matcher.services.service;

import ru.matcher.commons.OrganizationType;
import ru.matcher.data.model.Organization;
import ru.matcher.services.dto.OrganizationDto;

import java.util.List;

/**
 * Интерфейс сервиса для организации.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
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

    /**
     * Поиск Organization по типу организации.
     *
     * @param organizationType тип организации
     * @return список OrganizationDto
     */
    List<OrganizationDto> findByOrganizationType(Integer organizationType);

    /**
     * Поиск Organization по имени.
     *
     * @param name имя организации
     * @return найденный объект класса OrganizationDto
     */
    OrganizationDto findByName(String name);
}
