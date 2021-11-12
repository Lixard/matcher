package ru.matcher.services.dto.get;

import ru.matcher.data.model.User;
import ru.matcher.services.dto.UserDto;

/**
 * Dto класс для запроса на присоединение к проекту.
 *
 * @author максим Щербаков
 */
public class RequestGetDto {
    private Integer id;
    private UserDto user;
    private String  message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static final class Builder {
        private Integer id;
        private UserDto user;
        private String  message;

        private Builder() {
        }

        public static Builder aRequestGetDto() {
            return new Builder();
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withUser(UserDto user) {
            this.user = user;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public RequestGetDto build() {
            RequestGetDto requestGetDto = new RequestGetDto();
            requestGetDto.setId(id);
            requestGetDto.setUser(user);
            requestGetDto.setMessage(message);
            return requestGetDto;
        }
    }
}
