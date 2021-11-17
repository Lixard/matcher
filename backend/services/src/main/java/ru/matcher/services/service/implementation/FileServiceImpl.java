package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.matcher.data.model.File;
import ru.matcher.data.repository.FileRepository;
import ru.matcher.services.dto.FileDto;
import ru.matcher.services.mapstruct.FileStruct;
import ru.matcher.services.service.IFileService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements IFileService {

    private final FileRepository fileRepository;
    private final FileStruct fileStruct;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository, FileStruct fileStruct) {
        this.fileRepository = fileRepository;
        this.fileStruct = fileStruct;
    }


    @Override
    @Transactional
    public FileDto create(MultipartFile[] files, int projectId) {
        File projectFile = null;
        for (MultipartFile file : files) {
            try {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                projectFile = new File(fileName, file.getContentType(), file.getBytes().length, file.getBytes());
                fileRepository.save(projectFile);
                fileRepository.insertProjectFile(projectId, projectFile.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileStruct.toDto(projectFile);
    }

    @Override
    @Transactional
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

    @Override
    public List<FileDto> getFilesByProject(Integer projectId) {
        return fileRepository.findFilesByProject(projectId)
                .stream()
                .map(fileStruct::toDto)
                .collect(Collectors.toList());
    }

}
