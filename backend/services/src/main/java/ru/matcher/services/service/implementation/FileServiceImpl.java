package ru.matcher.services.service.implementation;

import org.springframework.stereotype.Service;
import ru.matcher.data.model.File;
import ru.matcher.data.repository.FileRepository;
import ru.matcher.services.dto.FileDto;
import ru.matcher.services.mapstruct.FileStruct;
import ru.matcher.services.service.FileService;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final FileStruct fileStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public FileServiceImpl(FileRepository fileRepository,
                           FileStruct fileStruct) {
        this.fileRepository = fileRepository;
        this.fileStruct = fileStruct;
    }

    @Override
    public FileDto createOrUpdate(FileDto fileDto) {
        File file = fileStruct.fromDto(fileDto);
        fileRepository.save(file);
        return fileStruct.toDto(file);
    }

    @Override
    public void remove(int fileId) {
        fileRepository.deleteById(fileId);
    }

    @Override
    public List<FileDto> getFiles() {
        return fileStruct.toDto(fileRepository.findAll());
    }

    @Override
    public FileDto findById(int fileId) {
        return fileStruct.toDto(fileRepository.findById(fileId).orElseThrow());
    }
}
