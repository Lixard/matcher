package ru.matcher.services.service;

import org.springframework.web.multipart.MultipartFile;
import ru.matcher.services.dto.PictureDto;

import java.io.IOException;
import java.util.List;

/**
 * Интерфейс сервиса для картинки.
 *
 * @author Николай Евсюков
 */
public interface IPictureService {

    /**
     * Добавление картинки в БД.
     *
     * @param file картинка для добавления
     * @return объект класса PictureDto
     */
    PictureDto create(MultipartFile file) throws IOException;

    /**
     * Обновление картинки в БД.
     *
     * @param pictureDto картинка для обновления
     * @return объект класса PictureDto
     */
    PictureDto update(PictureDto pictureDto) throws IOException;

    /**
     * Удаление картинки из БД.
     *
     * @param pictureId идентификатор картинки
     */
    void remove(int pictureId);

    /**
     * Возвращяет список PictureDto из БД.
     *
     * @return список PictureDto
     */
    List<PictureDto> getPictures();

    /**
     * Поиск картики по id.
     *
     * @param pictureId идентификатор картинки
     * @return найденный объект класса PictureDto
     */
    PictureDto findById(int pictureId);
}
