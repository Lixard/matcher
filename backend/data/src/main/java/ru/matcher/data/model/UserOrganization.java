package ru.matcher.data.model;

import ru.matcher.data.model.embedded.UserOrganizationEmbeddedId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Таблица организации пользователя.
 *
 * @author Максим Щербаков
 */
@Entity
@Table(name = "user_organizations", schema = "matcher")
public class UserOrganization {

    @EmbeddedId
    private UserOrganizationEmbeddedId id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    public UserOrganizationEmbeddedId getId() {
        return id;
    }

    public void setId(UserOrganizationEmbeddedId id) {
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
}
