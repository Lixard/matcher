package ru.matcher.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Таблица типа организации.
 *
 * @author Максим Щербаков
 */
@Entity
@Table(name = "org_types", schema = "matcher")
@Getter
@Setter
public class OrganizationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;
}
