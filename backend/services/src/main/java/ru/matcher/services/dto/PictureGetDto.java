package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto класс для картинки.
 *
 * @author Николай Евсюков
 */
@Getter
@Setter
public class PictureGetDto {

    private Integer id;
    private String name;
    private String type;
}
