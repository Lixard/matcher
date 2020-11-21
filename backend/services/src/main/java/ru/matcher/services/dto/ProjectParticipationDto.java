package ru.matcher.services.dto;

import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;

import java.time.LocalDate;

/**
 * Dto класс для пользователей учавствовавших в проектах.
 *
 * @author Николай Евсюков
 */
public class ProjectParticipationDto {

    private ProjectUserEmbeddedId id;
    private Integer userId;
    private Integer projectId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isAdmin;

    public ProjectUserEmbeddedId getId() {
        return id;
    }

    public void setId(ProjectUserEmbeddedId id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
