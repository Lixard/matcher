package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.matcher.data.model.File;
import ru.matcher.data.repository.FileRepository;
import ru.matcher.services.dto.FileDto;
import ru.matcher.services.mapstruct.FileStruct;
import ru.matcher.services.service.IFileService;

import java.io.IOException;
import java.util.List;

public class FileServiceImpl implements IFileService {

    private final FileRepository fileRepository;
    private final FileStruct fileStruct;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository, FileStruct fileStruct) {
        this.fileRepository = fileRepository;
        this.fileStruct = fileStruct;
    }

    @Override
    public FileDto create(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //long fileSizeInMegaBytes = file.getBytes().length/(1024*1024);
        File projectFile = new File(fileName, file.getContentType(), file.getBytes().length, file.getBytes());

        fileRepository.save(projectFile);
        return fileStruct.toDto(projectFile);
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
        return fileStruct.toDto(fileRepository.findById(fileId).orElse(null));
    }
}
