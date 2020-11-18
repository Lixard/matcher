package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto класс для проектов.
 *
 * @author Николай Евсюков
 */
@Getter
@Setter
public class ProjectDto {

    private Integer id;
    private PictureGetDto pictureGetDto;
    private String name;
    private String description;
    private boolean isActive;
}