package ru.matcher.data.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Таблица пользователя.
 *
 * @author Максим Щербаков
 */
@Entity
@Table(name = "users", schema = "matcher")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @ManyToOne(targetEntity = File.class)
    @JoinColumn(name = "picture_id")
    private File picture;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
}
