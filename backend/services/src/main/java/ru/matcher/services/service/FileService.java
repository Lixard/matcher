package ru.matcher.services.service;

import ru.matcher.services.dto.FileDto;

import java.util.List;

public interface FileService {

    FileDto createOrUpdate(FileDto fileDto);

    void remove(int fileId);

    List<FileDto> getFiles();

    FileDto findById(int fileId);
}
