package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import ru.matcher.data.model.Picture;
import ru.matcher.services.dto.PictureDto;

import java.util.List;

/**
 * Маппер для картинки.
 *
 * @author Николай Евсюков
 */
@Mapper
public interface PictureStruct {

    /**
     * Превращение Picture в PictureDto.
     *
     * @param picture объект класса Picture
     * @return объект класса PictureDto
     */
    PictureDto toDto(Picture picture);

    /**
     * Превражение PictureDto в Picture.
     *
     * @param pictureDto объект класса PictureDto
     * @return объект класса Picture
     */
    Picture fromDto(PictureDto pictureDto);

    /**
     * Превращение списка Picture в список PictureDto.
     *
     * @param pictures список Picture
     * @return список PictureDto
     */
    List<PictureDto> toDto(List<Picture> pictures);

    /**
     * Превращение списка PictureDto в список Picture.
     *
     * @param pictureDtos список PictureDto
     * @return список Picture
     */
    List<Picture> fromDto(List<PictureDto> pictureDtos);
}
