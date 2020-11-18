package ru.matcher.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Таблица организации.
 *
 * @author Максим Щербаков
 * @author Николай Евсюков
 */
@Entity
@Table(name = "organizations", schema = "matcher")
@Getter
@Setter
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Picture.class)
    @JoinColumn(name = "picture_id")
    private Picture picture;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(targetEntity = OrganizationType.class)
    @JoinColumn(name = "org_type_id")
    private OrganizationType organizationType;

    @Column(name = "description")
    private String description;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;
}
