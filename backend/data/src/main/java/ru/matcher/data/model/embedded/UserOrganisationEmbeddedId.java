package ru.matcher.data.model.embedded;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Составной ключ таблицы организации пользователя.
 *
 * @author Максим Щербаков
 */
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class UserOrganisationEmbeddedId implements Serializable {
    @Column(name = "user_id")
    private Integer user;

    @Column(name = "org_id")
    private Integer organization;
}
