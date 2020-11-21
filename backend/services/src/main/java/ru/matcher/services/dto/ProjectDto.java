package ru.matcher.services.dto;

import ru.matcher.services.dto.get.PictureGetDto;

/**
 * Dto класс для проектов.
 *
 * @author Николай Евсюков
 */
public class ProjectDto {

    private Integer id;
    private PictureGetDto pictureGetDto;
    private String name;
    private String description;
    private boolean isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PictureGetDto getPictureGetDto() {
        return pictureGetDto;
    }

    public void setPictureGetDto(PictureGetDto pictureGetDto) {
        this.pictureGetDto = pictureGetDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
