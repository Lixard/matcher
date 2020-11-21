package ru.matcher.services.service;

import ru.matcher.services.dto.PictureDto;

import java.util.List;

/**
 * Интерфейс сервиса для файла.
 *
 * @author Николай Евсюков
 */
public interface IPictureService {

    /**
     * Добавление File в БД.
     *
     * @param pictureDto объект класса FileDto
     * @return объект класса FileDto
     */
    PictureDto create(PictureDto pictureDto);

    /**
     * Обновление File в БД.
     *
     * @param pictureDto объект класса FileDto
     * @return объект класса FileDto
     */
    PictureDto update(PictureDto pictureDto);

    /**
     * Удаление File из БД.
     *
     * @param fileId идентификатор File
     */
    void remove(int fileId);

    /**
     * Возвращяет список FileDto из БД.
     *
     * @return список FileDto
     */
    List<PictureDto> getFiles();

    /**
     * Поиск File по id.
     *
     * @param fileId идентификатор File
     * @return найденный объект класса FileDto
     */
    PictureDto findById(int fileId);
}
