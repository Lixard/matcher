package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto класс для файла.
 *
 * @author Николай Евсюков
 */
@Getter
@Setter
public class FileDto {

    private Integer id;
    private String name;
    private String type;
    private byte[] data;
}
