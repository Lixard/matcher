package ru.matcher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.matcher.services.dto.FileDto;
import ru.matcher.services.service.IFileService;

import java.io.IOException;
import java.util.List;

/**
 * Контроллер для файлов.
 *
 * @author Максим Комов
 *
 */
@RestController
@RequestMapping(
        path = "/files",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class FileController {

    private final IFileService fileService;

    @Autowired
    public FileController(IFileService fileService) {
        this.fileService = fileService;
    }

    /**
     * Добавление файла.
     *
     * @param file файл для добавления
     * @return добавленный файл
     */
    @PostMapping("/create")
    public FileDto createFile(@RequestParam("file") MultipartFile file) throws IOException {
        return fileService.create(file);
    }

    /**
     * Удаление файла.
     *
     * @param id идентификатор файла
     */
    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable Integer id) {
        fileService.remove(id);
    }

    /**
     * Список всех файлов.
     *
     * @return список всех файлов
     */
    @GetMapping
    public List<FileDto> getFiles() {
        return fileService.getFiles();
    }

    /**
     * Поиск файла по ID.
     *
     * @param id идентификатор файла
     * @return найденная файл
     */
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFileById(@PathVariable Integer id) {
        FileDto fileDto = fileService.findById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDto.getName() + "\"")
                .body(fileDto.getData());
    }

    @GetMapping("/file/{id}")
    public FileDto getFullFileById(@PathVariable Integer id) {
        return fileService.findById(id);
    }
}
