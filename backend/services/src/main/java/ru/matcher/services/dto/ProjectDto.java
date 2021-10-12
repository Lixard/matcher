package ru.matcher.services.dto;

/**
 * Dto класс для проектов.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
 */
public class ProjectDto {

    private Integer id;
    private PictureDto picture;
    private String name;
    private String description;
    private String lifecycle;
    private String currentLifecycle;
    private boolean isActive;
    private int organizationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PictureDto getPicture() {
        return picture;
    }

    public void setPicture(PictureDto picture) {
        this.picture = picture;
    }

    public String getCurrentLifecycle() {
        return currentLifecycle;
    }

    public void setCurrentLifecycle(String currentLifecycle) {
        this.currentLifecycle = currentLifecycle;
    }

    public String getName() {
        return name;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
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

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
}
