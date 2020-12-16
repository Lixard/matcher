package ru.matcher.services.service;

import org.springframework.web.multipart.MultipartFile;
import ru.matcher.services.dto.PictureDto;

import java.io.IOException;
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
     * @param file файл для добавления
     * @return объект класса FileDto
     */
    PictureDto create(MultipartFile file) throws IOException;

    /**
     * Обновление File в БД.
     *
     * @param file файл для добавления
     * @return объект класса FileDto
     */
    PictureDto update(PictureDto pictureDto) throws IOException;

    /**
     * Удаление File из БД.
     *
     * @param pictureId идентификатор File
     */
    void remove(int pictureId);

    /**
     * Возвращяет список FileDto из БД.
     *
     * @return список FileDto
     */
    List<PictureDto> getPictures();

    /**
     * Поиск File по id.
     *
     * @param pictureId идентификатор File
     * @return найденный объект класса FileDto
     */
    PictureDto findById(int pictureId);
}
