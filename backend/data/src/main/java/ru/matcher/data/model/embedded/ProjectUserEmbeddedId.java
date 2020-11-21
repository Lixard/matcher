package ru.matcher.data.model.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Составной ключ таблицы проектов пользователя.
 *
 * @author Максим Щербаков
 */
@Embeddable
public class ProjectUserEmbeddedId implements Serializable {
    @Column(name = "user_id")
    private Integer user;

    @Column(name = "project_id")
    private Integer project;

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectUserEmbeddedId that = (ProjectUserEmbeddedId) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, project);
    }
}
