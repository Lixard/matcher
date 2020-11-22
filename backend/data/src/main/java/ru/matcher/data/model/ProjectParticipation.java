package ru.matcher.data.model;

import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;

import javax.persistence.*;
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

    @MapsId("user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @MapsId("project_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    public ProjectUserEmbeddedId getId() {
        return id;
    }

    public void setId(ProjectUserEmbeddedId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
