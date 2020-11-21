package ru.matcher.services.dto;

import ru.matcher.data.model.embedded.UserOrganisationEmbeddedId;

import java.time.LocalDate;

/**
 * Dto класс для организаций пользователя.
 *
 * @author Николай Евсюков
 */
public class UserOrganizationDto {

    private UserOrganisationEmbeddedId id;
    private Integer userId;
    private Integer organizationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isAdmin;

    public UserOrganisationEmbeddedId getId() {
        return id;
    }

    public void setId(UserOrganisationEmbeddedId id) {
        this.id = id;
    }

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
}
