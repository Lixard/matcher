package ru.matcher.services.service;

import ru.matcher.services.dto.FileDto;

import java.util.List;

/**
 * Интерфейс сервиса для файла.
 *
 * @author Николай Евсюков
 */
public interface FileService {

    /**
     * Добавление или обновление File в БД.
     *
     * @param fileDto объект класса FileDto
     * @return объект класса FileDto
     */
    FileDto createOrUpdate(FileDto fileDto);

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
    List<FileDto> getFiles();

    /**
     * Поиск File по id.
     *
     * @param fileId идентификатор File
     * @return найденный объект класса FileDto
     */
    FileDto findById(int fileId);
}
