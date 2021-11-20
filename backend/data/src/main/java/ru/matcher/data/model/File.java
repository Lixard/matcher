package ru.matcher.data.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Таблица для хранения файлов.
 *
 * @author Максим Комов
 */
@Entity
@Table(name = "files", schema = "matcher")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "size", nullable = false)
    private long size;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "data", nullable = false)
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;

    public File() {
    }

    public File(String name, String type, long size, byte[] data) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.data = data;
    }

    private File(Builder builder) {
        id = builder.id;
        name = builder.name;
        type = builder.type;
        size = builder.size;
        createdAt = builder.createdAt;
        data = builder.data;
    }

    public static Builder builder() {
        return new Builder();
    }


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public static class Builder {

        private Integer id;
        private String name;
        private String type;
        private long size;
        private LocalDateTime createdAt;
        private byte[] data;

        private Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder size(long size) {
            this.size = size;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public File build() {
            return new File(this);
        }
    }
}
