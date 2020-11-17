package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import ru.matcher.data.model.File;
import ru.matcher.services.dto.FileDto;

import java.util.List;

@Mapper
public interface FileStruct {

    FileDto toDto(File file);

    File fromDto(FileDto fileDto);

    List<FileDto> toDto(List<File> files);

    List<File> fromDto(List<FileDto> fileDtos);
}
