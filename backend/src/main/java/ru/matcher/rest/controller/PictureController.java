package ru.matcher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.matcher.services.dto.PictureDto;
import ru.matcher.services.service.IPictureService;

import java.io.IOException;
import java.util.List;

/**
 * Контроллер для картинок.
 *
 * @author Николай Евсюков
 */
@RestController
@RequestMapping(
        path = "/pictures",
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
     * @param file картинка для добавления
     * @return добавленная картинка
     */
    @PostMapping("/create")
    public PictureDto createPicture(@RequestParam("file") MultipartFile file) throws IOException {
        return pictureService.create(file);
    }

    /**
     * Обновление картинки.
     *
     * @param id   идентификатор картинки
     * @param file новая картинка
     * @return обновлённая картинка
     */
    @PutMapping("/{id}")
    public PictureDto updatePicture(@PathVariable Integer id,
                                    @RequestParam("file") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        PictureDto pictureDto = new PictureDto();
        pictureDto.setId(id);
        pictureDto.setName(fileName);
        pictureDto.setType(file.getContentType());
        pictureDto.setData(file.getBytes());
        return pictureService.update(pictureDto);
    }

    /**
     * Удаление картинки.
     *
     * @param id идентификатор картинки
     */
    @DeleteMapping("/{id}")
    public void deletePicture(@PathVariable Integer id) {
        pictureService.remove(id);
    }

    /**
     * Список всех картинок.
     *
     * @return список всех картинок
     */
    @GetMapping
    public List<PictureDto> getPictures() {
        return pictureService.getPictures();
    }

    /**
     * Поиск картнки по ID.
     *
     * @param id идентификатор картнки
     * @return найденная картнка
     */
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getPictureById(@PathVariable Integer id) {
        PictureDto pictureDto = pictureService.findById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pictureDto.getName() + "\"")
                .body(pictureDto.getData());
    }
}
