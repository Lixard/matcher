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
 * Таблица для запросов на присоединение к проекту.
 *
 * @author Максим Щербаков
 */
@Entity
@Table(name = "requests", schema = "matcher")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer id;

    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
