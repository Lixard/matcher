package ru.matcher.services.dto;

import java.time.LocalDate;

/**
 * Dto класс для организаций пользователя.
 *
 * @author Николай Евсюков
 */
public class UserOrganizationDto {

    private Integer userId;
    private Integer organizationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isAdmin;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
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

    public static final class Builder {

        private Integer userId;
        private Integer organizationId;
        private LocalDate startDate;
        private LocalDate endDate;
        private boolean isAdmin;

        private Builder() {
        }

        public static Builder anUserOrganizationDto() {
            return new Builder();
        }

        public Builder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder withOrganizationId(Integer organizationId) {
            this.organizationId = organizationId;
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

        public UserOrganizationDto build() {
            UserOrganizationDto userOrganizationDto = new UserOrganizationDto();
            userOrganizationDto.setUserId(userId);
            userOrganizationDto.setOrganizationId(organizationId);
            userOrganizationDto.setStartDate(startDate);
            userOrganizationDto.setEndDate(endDate);
            userOrganizationDto.isAdmin = this.isAdmin;
            return userOrganizationDto;
        }
    }
}
