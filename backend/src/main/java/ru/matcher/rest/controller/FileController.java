package ru.matcher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.matcher.services.dto.FileDto;
import ru.matcher.services.dto.ProjectDto;
import ru.matcher.services.service.IFileService;
import ru.matcher.services.service.IProjectService;

import java.io.IOException;
import java.util.List;

/**
 * Контроллер для файлов.
 *
 * @author Максим Комов
 */
@RestController
@RequestMapping(
        path = "/files",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class FileController {

    private final IFileService fileService;
    private final IProjectService projectService;

    @Autowired
    public FileController(IFileService fileService, IProjectService projectService) {
        this.fileService = fileService;
        this.projectService = projectService;
    }


    /**
     * Добавление файла.
     *
     * @param file файл для добавления
     * @return добавленный файл
     */
    @PostMapping("/project/{projectId}/create")
    public FileDto createFile(@RequestParam("file") MultipartFile file, @PathVariable Integer projectId) throws IOException {
        FileDto fileDto = fileService.create(file, projectId);

        return fileDto;
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
     * @return найденный файл
     */
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFileById(@PathVariable Integer id) {
        FileDto fileDto = fileService.findById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDto.getName() + "\"")
                .body(fileDto.getData());
    }

    /**
     * Поиск файла по ID.
     *
     * @param id идентификатор файла
     * @return найденный файл
     */
    @GetMapping("/file/{id}")
    public FileDto getFullFileById(@PathVariable Integer id) {
        return fileService.findById(id);
    }


    /**
     * Поиск файлов по ID проекта.
     *
     * @param projectId идентификатор файла
     * @return найденные файлы
     */
    @GetMapping("/project/{projectId}")
    public List<FileDto> getFilesByProject(@PathVariable Integer projectId) {
        ProjectDto projectDto = projectService.findById(projectId);
        List<FileDto> fileDtos = fileService.getFilesByProject(projectDto.getId());
        return fileDtos;
    }

    /**
     * Загрузка файлов по ID файлу.
     *
     * @param fileId идентификатор файла
     * @return найденные файлы
     */
    @GetMapping("/download/{fileId}")
    public void downloadFileById(@PathVariable Integer fileId) {
        try {
            fileService.downloadFile(fileId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
