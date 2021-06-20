package ru.matcher.services.dto.update;

/**
 * Dto класс для обновления организации пользователя.
 *
 * @author Максим Щербаков
 */
public class UserOrganizationUpdate {
    private Integer userId;
    private String place;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
