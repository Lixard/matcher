package ru.matcher.services.dto;

import ru.matcher.commons.OrganizationType;

/**
 * Dto класс для организации.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
 */
public class OrganizationDto {

    private Integer id;
    private Integer pictureId;
    private String name;
    private OrganizationType organizationType;
    private String description;
    private String url;
    private String email;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationType organizationTypeId) {
        this.organizationType = organizationTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
