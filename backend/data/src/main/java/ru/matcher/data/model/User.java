package ru.matcher.data.model;

import ru.matcher.commons.UserType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Таблица пользователя.
 *
 * @author Максим Щербаков
 * @author Николай Евсюков
 * @author Андрей Герасимов
 */
@Entity
@Table(name = "users", schema = "matcher")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "picture_id")
    private Picture picture;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "user_type_id", nullable = false)
    private UserType userType;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            schema = "matcher",
            name = "user_competencies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id"))
    private Set<Competence> competencies = new HashSet<>();

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Set<Competence> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(Set<Competence> competencies) {
        this.competencies = competencies;
    }


    public static final class Builder {
        private Integer id;
        private Picture picture;
        private String login;
        private String password;
        private String firstName;
        private UserType userType;
        private String lastName;
        private String secondName;
        private String email;
        private String phone;
        private Set<Competence> competencies = new HashSet<>();

        private Builder() {
        }

        public static Builder anUser() {
            return new Builder();
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withPicture(Picture picture) {
            this.picture = picture;
            return this;
        }

        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withUserType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withCompetencies(Set<Competence> competencies) {
            this.competencies = competencies;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setPicture(picture);
            user.setLogin(login);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setUserType(userType);
            user.setLastName(lastName);
            user.setSecondName(secondName);
            user.setEmail(email);
            user.setPhone(phone);
            user.setCompetencies(competencies);
            return user;
        }
    }
}
