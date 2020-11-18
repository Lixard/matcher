package ru.matcher.data.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Таблица для хранения файлов.
 *
 * @author Максим Щербаков
 * @author Николай Евсюков
 */
@Entity
@Table(name = "pictures", schema = "matcher")
@Getter
@Setter
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picture_id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "data", nullable = false)
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;
}
