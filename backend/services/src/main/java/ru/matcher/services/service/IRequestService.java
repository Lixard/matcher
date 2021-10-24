package ru.matcher.services.service;

import ru.matcher.services.dto.RequestDto;

import java.util.List;

/**
 * Интерфейс сервиса для запросов на присоединение к проекту.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
 */
public interface IRequestService {

    /**
     * Добавление Request в БД.
     *
     * @param requestDto объект класса RequestDto
     * @return объект класса RequestDto
     */
    RequestDto create(RequestDto requestDto);

    /**
     * Удаление Request из БД.
     *
     * @param requestId идентификатор Request
     */
    void remove(int requestId);

    /**
     * Принятие запроса и удаление Request из БД.
     *
     * @param requestId идентификатор Request
     */
    void acceptAndRemove(int requestId);

    /**
     * Возвращает список RequestDto из БД по id проекта.
     *
     * @return список RequestDto
     */
    List<RequestDto> getRequestsByProjectId(Integer projectId);

    /**
     * Возвращает возможность подачи заявки на присоединение к проекту.
     *
     * @return true или false в зависимости от того может ли пользователь подать заявку на вступление
     */
    boolean canSubscribe(Integer userId, Integer projectId);
}
