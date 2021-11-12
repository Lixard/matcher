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
    @PostMapping("/files/project/{projectId}/create")
    public FileDto createFile(@RequestParam("file") MultipartFile file, @PathVariable Integer projectId) throws IOException {
        FileDto fileDto = fileService.create(file, projectId);

        return fileDto;
    }

    /**
     * Удаление файла.
     *
     * @param id идентификатор файла
     */
    @DeleteMapping("/files/{id}")
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
     * @param fileId идентификатор файла
     * @return найденный файл
     */
    @GetMapping("/projects/{projectId}/files/{fileId}")
    public ResponseEntity<byte[]> downloadFileById(@PathVariable Integer fileId) {
        FileDto fileDto = fileService.findById(fileId);
        ResponseEntity<byte[]> fileToDownload = ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileDto.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                        + fileDto.getName().replace(" ", "_") + "\"")
                .contentLength(fileDto.getData().length)
                .body(fileDto.getData());
        return fileToDownload;
    }

    /**
     * Поиск файлов по ID проекта.
     *
     * @param projectId идентификатор файла
     * @return найденные файлы
     */
    @GetMapping("/projects/{projectId}/files")
    public List<FileDto> getFilesByProject(@PathVariable Integer projectId) {
        ProjectDto projectDto = projectService.findById(projectId);
        return fileService.getFilesByProject(projectDto.getId());
    }

}
