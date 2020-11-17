package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;
import ru.matcher.data.model.File;

@Getter
@Setter
public class ProjectDto {

    private Integer id;
    private File picture;
    private String name;
    private String description;
    private boolean isActive;
}
