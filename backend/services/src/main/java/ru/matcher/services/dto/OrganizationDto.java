package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto класс для организации.
 *
 * @author Николай Евсюков
 */
@Getter
@Setter
public class OrganizationDto {

    private Integer id;
    private PictureGetDto pictureGetDto;
    private String name;
    private Integer organizationTypeId;
    private String description;
    private String url;
    private String email;
    private String address;
}
