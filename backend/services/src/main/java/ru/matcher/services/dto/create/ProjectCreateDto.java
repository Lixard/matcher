package ru.matcher.services.dto.create;

import ru.matcher.services.dto.ProjectDto;

public class ProjectCreateDto extends ProjectDto {
    private String name;
    private String description;
    private String lifecycle;
    private String current_lifecycle;
    private Integer pictureId;
    private int userId;
    private int organizationId;

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

    @Override
    public String getLifecycle() {
        return lifecycle;
    }

    @Override
    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    @Override
    public String getCurrent_lifecycle() {
        return current_lifecycle;
    }

    @Override
    public void setCurrent_lifecycle(String current_lifecycle) {
        this.current_lifecycle = current_lifecycle;
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
    public int getOrganizationId() {
        return organizationId;
    }

    @Override
    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
}
