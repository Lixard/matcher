package ru.matcher.data.model;

import ru.matcher.data.model.embedded.UserOrganisationEmbeddedId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
    private UserOrganisationEmbeddedId id;

    @MapsId("user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @MapsId("org_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    public UserOrganisationEmbeddedId getId() {
        return id;
    }

    public void setId(UserOrganisationEmbeddedId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
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
