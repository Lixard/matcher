package ru.matcher.services.dto;

/**
 * Dto класс для типа организации.
 *
 * @author Николай Евсюков
 */
public class OrganizationTypeDto {

    private Integer id;
    private String name;

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
}
