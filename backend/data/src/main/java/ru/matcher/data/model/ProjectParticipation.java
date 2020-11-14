package ru.matcher.data.model;

import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
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
}
