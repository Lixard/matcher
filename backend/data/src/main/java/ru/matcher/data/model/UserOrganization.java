package ru.matcher.data.model;


import ru.matcher.data.model.embedded.UserOrganisationEmbeddedId;

import javax.persistence.*;
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
}
