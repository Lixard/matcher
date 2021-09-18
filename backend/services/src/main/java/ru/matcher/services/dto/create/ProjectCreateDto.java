package ru.matcher.services.dto.create;

import ru.matcher.services.dto.ProjectDto;

public class ProjectCreateDto extends ProjectDto {
    private String name;
    private String description;
    private Integer pictureId;
    private Integer userId;
    private Integer organizationId;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public Integer getOrganizationId() {
        return organizationId;
    }

    @Override
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
}
