package ru.matcher.data.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "competencies", schema = "matcher")
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competence_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "competencies")
    private Set<User> users = new HashSet<>();

    public Competence() {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public static final class Builder {
        private Integer id;
        private String name;
        private Set<User> users = new HashSet<>();

        private Builder() {
        }

        public static Builder aCompetence() {
            return new Builder();
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withUsers(Set<User> users) {
            this.users = users;
            return this;
        }

        public Competence build() {
            Competence competence = new Competence();
            competence.setId(id);
            competence.setName(name);
            competence.setUsers(users);
            return competence;
        }
    }
}
