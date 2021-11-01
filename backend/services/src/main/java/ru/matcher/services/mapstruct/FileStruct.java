package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import ru.matcher.data.model.File;
import ru.matcher.data.model.Picture;
import ru.matcher.services.dto.FileDto;
import ru.matcher.services.dto.PictureDto;

import java.util.List;

/**
 * Маппер для файла.
 *
 * @author Николай Евсюков
 */
@Mapper
public interface FileStruct {

    /**
     * Превращение File в FileDto.
     *
     * @param file объект класса File
     * @return объект класса FileDto
     */
    FileDto toDto(File file);

    /**
     * Превражение FileDto в File.
     *
     * @param fileDto объект класса FileDto
     * @return объект класса File
     */
    File fromDto(FileDto fileDto);

    /**
     * Превращение списка File в список FileDto.
     *
     * @param files список File
     * @return список FileDto
     */
    List<FileDto> toDto(List<File> files);

    /**
     * Превращение списка FileDto в список File.
     *
     * @param fileDtos список FileDto
     * @return список File
     */
    List<File> fromDto(List<FileDto> fileDtos);
}
