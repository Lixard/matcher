package ru.matcher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.matcher.services.dto.PictureDto;
import ru.matcher.services.service.IPictureService;

import java.util.List;

/**
 * Контроллер для картинок.
 *
 * @author Николай Евсюков
 */
@RestController
@RequestMapping(
        path = "/picture",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class PictureController {

    private final IPictureService pictureService;

    @Autowired
    public PictureController(IPictureService pictureService) {
        this.pictureService = pictureService;
    }

    /**
     * Добавление картинки.
     *
     * @param pictureDto картинка для добавления
     * @return добавленная картинка
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    PictureDto createPicture(@RequestBody PictureDto pictureDto) {
        return pictureService.create(pictureDto);
    }

    /**
     * Обновление картинки.
     *
     * @param id         идентификатор картинки
     * @param pictureDto новая картинка
     * @return обновлённая картинка
     */
    @PutMapping("/{id}")
    PictureDto updatePicture(@PathVariable int id,
                             @RequestBody PictureDto pictureDto) {
        pictureDto.setId(id);
        return pictureService.update(pictureDto);
    }

    /**
     * Удаленеи картинки.
     *
     * @param id идентификатор картинки
     */
    @DeleteMapping("/{id}")
    void deletePicture(@PathVariable int id) {
        pictureService.remove(id);
    }

    /**
     * Список всех картинок.
     *
     * @return список всех картинок
     */
    @GetMapping
    List<PictureDto> getPictures() {
        return pictureService.getPictures();
    }

    /**
     * Поиск картнки по ID.
     *
     * @param id идентификатор картнки
     * @return найденная картнка
     */
    @GetMapping("/{id}")
    PictureDto getPictureById(@PathVariable int id) {
        return pictureService.findById(id);
    }
}
