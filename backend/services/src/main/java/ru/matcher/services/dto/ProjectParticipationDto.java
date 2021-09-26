package ru.matcher.services.dto;

import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;

import java.time.LocalDate;

/**
 * Dto класс для пользователей учавствовавших в проектах.
 *
 * @author Николай Евсюков
 */
public class ProjectParticipationDto {

    private Integer userId;
    private Integer projectId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isAdmin;
    private String userRole;

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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public static final class Builder {
        private Integer userId;
        private Integer projectId;
        private LocalDate startDate;
        private LocalDate endDate;
        private boolean isAdmin;
        private String userRole;

        private Builder() {
        }

        public static Builder aProjectParticipationDto() {
            return new Builder();
        }

        public Builder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder withProjectId(Integer projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder withIsAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public Builder withUserRole(String userRole) {
            this.userRole = userRole;
            return this;
        }

        public ProjectParticipationDto build() {
            ProjectParticipationDto projectParticipationDto = new ProjectParticipationDto();
            projectParticipationDto.setUserId(userId);
            projectParticipationDto.setProjectId(projectId);
            projectParticipationDto.setStartDate(startDate);
            projectParticipationDto.setEndDate(endDate);
            projectParticipationDto.setUserRole(userRole);
            projectParticipationDto.isAdmin = this.isAdmin;
            return projectParticipationDto;
        }
    }
}
