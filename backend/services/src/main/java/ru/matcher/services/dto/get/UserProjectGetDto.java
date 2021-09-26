package ru.matcher.services.dto.get;

public class UserProjectGetDto {

    private int id;
    private String lastName;
    private String firstName;
    private boolean isAdmin;
    private String userRole;

    public UserProjectGetDto(int id, String lastName, String firstName, boolean isAdmin, String userRole) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.isAdmin = isAdmin;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


    public static final class Builder {
        private int id;
        private String lastName;
        private String firstName;
        private boolean isAdmin;
        private String userRole;

        private Builder() {
        }

        public static Builder anUserProjectGetDto() {
            return new Builder();
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withIsAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public Builder withUserRole(String userRole) {
            this.userRole = userRole;
            return this;
        }

        public UserProjectGetDto build() {
            return new UserProjectGetDto(id, lastName, firstName, isAdmin, userRole);
        }
    }
}
