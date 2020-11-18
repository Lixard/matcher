package ru.matcher.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Таблица проектов.
 *
 * @author Максим Щербаков
 * @author Николай Евсюков
 */
@Entity
@Table(name = "projects", schema = "matcher")
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer id;

    @ManyToOne(targetEntity = Picture.class)
    @JoinColumn(name = "picture_id")
    private Picture picture;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}
