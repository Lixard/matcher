package ru.matcher.services.service;

import org.springframework.web.multipart.MultipartFile;
import ru.matcher.services.dto.FileDto;
import ru.matcher.services.dto.PictureDto;

import java.io.IOException;
import java.util.List;

/**
 * Интерфейс сервиса для файлов.
 *
 * @author Максим Комов
 */
public interface IFileService {

    /**
     * Добавление файла в БД.
     *
     * @param file файл для добавления
     * @return объект класса FileDto
     */
    FileDto create(MultipartFile file) throws IOException;

    /**
     * Удаление файла из БД.
     *
     * @param fileId идентификатор картинки
     */
    void remove(int fileId);

    /**
     * Возвращает список FileDto из БД.
     *
     * @return список FileDto
     */
    List<FileDto> getFiles();

    /**
     * Поиск файла по id.
     *
     * @param fileId идентификатор файла
     * @return найденный объект класса FileDto
     */
    FileDto findById(int fileId);
}
