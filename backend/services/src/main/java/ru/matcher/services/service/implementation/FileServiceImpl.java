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
import java.util.Objects;
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
    public List<FileDto> create(List<MultipartFile> files, int projectId) {
        return files.stream()
                .map(f -> File.builder()
                        .name(StringUtils.cleanPath(Objects.requireNonNull(f.getOriginalFilename())))
                        .type(f.getContentType())
                        .size(tryToGetBytes(f).length)
                        .data(tryToGetBytes(f))
                        .build()
                )
                .map(fileRepository::save)
                .map(f -> insertProjectFile(projectId, f))
                .map(fileStruct::toDto)
                .collect(Collectors.toList());
    }

    private File insertProjectFile(int projectId, File file) {
        fileRepository.insertProjectFile(projectId, file.getId());
        return file;
    }

    private byte[] tryToGetBytes(final MultipartFile file) {
        try {
            return file.getBytes();
        } catch (IOException e) {
            throw new IllegalStateException("Failed to get bytes from file");
        }
    }

    @Override
    @Transactional
    public void remove(Integer fileId) {
        fileRepository.deleteById(fileId);
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
