package ru.matcher.data.model.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Составной ключ таблицы организации пользователя.
 *
 * @author Максим Щербаков
 */
@Embeddable
public class UserOrganisationEmbeddedId implements Serializable {
    @Column(name = "user_id")
    private Integer user;

    @Column(name = "org_id")
    private Integer organization;

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getOrganization() {
        return organization;
    }

    public void setOrganization(Integer organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrganisationEmbeddedId that = (UserOrganisationEmbeddedId) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(organization, that.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, organization);
    }
}
