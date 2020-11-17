package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;
import ru.matcher.data.model.File;

/**
 * Dto класс для проектов.
 *
 * @author Николай Евсюков
 */
@Getter
@Setter
public class ProjectDto {

    private Integer id;
    private File picture;
    private String name;
    private String description;
    private boolean isActive;
}
