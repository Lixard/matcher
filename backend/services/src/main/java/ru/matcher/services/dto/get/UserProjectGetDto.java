package ru.matcher.services.dto.get;

public class UserProjectGetDto {

    private int id;
    private String lastName;
    private String firstName;
    private boolean isAdmin;

    public UserProjectGetDto(int id, String lastName, String firstName, boolean isAdmin) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.isAdmin = isAdmin;
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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public static final class Builder {
        private int id;
        private String lastName;
        private String firstName;
        private boolean isAdmin;

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

        public UserProjectGetDto build() {
            return new UserProjectGetDto(id, lastName, firstName, isAdmin);
        }
    }
}
