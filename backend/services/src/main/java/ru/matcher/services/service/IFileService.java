package ru.matcher.services.service;

import org.springframework.web.multipart.MultipartFile;
import ru.matcher.services.dto.FileDto;

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
     * @param files     файлы для добавления
     * @param projectId идентификатор проекта
     * @return объект класса FileDto
     */
    List<FileDto> create(List<MultipartFile> files, int projectId);

    /**
     * Удаление файла из БД.
     *
     * @param fileId идентификатор картинки
     */
    void remove(Integer fileId);

    /**
     * Поиск файла по id.
     *
     * @param fileId идентификатор файла
     * @return найденный объект класса FileDto
     */
    FileDto findById(int fileId);

    List<FileDto> getFilesByProject(Integer projectId);

}
