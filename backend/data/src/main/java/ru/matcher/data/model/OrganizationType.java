package ru.matcher.data.model;

import javax.persistence.*;

/**
 * Таблица типа организации.
 *
 * @author Максим Щербаков
 */
@Entity
@Table(name = "org_types", schema = "matcher")
public class OrganizationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
