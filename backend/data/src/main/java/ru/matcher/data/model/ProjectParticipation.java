package ru.matcher.data.model;

import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Таблица участия пользователя в проектах.
 *
 * @author Максим Щербаков
 */
@Entity
@Table(name = "project_participation", schema = "matcher")
public class ProjectParticipation {
    @EmbeddedId
    private ProjectUserEmbeddedId id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    @Column(name = "user_role", nullable = false)
    private String userRole;

    public ProjectUserEmbeddedId getId() {
        return id;
    }

    public void setId(ProjectUserEmbeddedId id) {
        this.id = id;
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
}
