package ru.matcher.services.dto;

/**
 * Dto класс для запросов на присоединение к проекту.
 *
 * @author Максим Щербаков
 */
public class RequestDto {
    private Integer id;
    private Integer userId;
    private Integer projectId;
    private String  message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
