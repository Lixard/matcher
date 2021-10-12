package ru.matcher.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Таблица проектов.
 *
 * @author Максим Щербаков
 * @author Николай Евсюков
 */
@Entity
@Table(name = "projects", schema = "matcher")
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

    @Column(name = "lifecycle")
    private String lifecycle;

    @Column(name = "current_lifecycle")
    private String currentLifecycle;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne(targetEntity = Organization.class)
    @JoinColumn(name = "org_id")
    private Organization organization;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentLifecycle() {
        return currentLifecycle;
    }

    public void setCurrentLifecycle(String currentLifecycle) {
        this.currentLifecycle = currentLifecycle;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
