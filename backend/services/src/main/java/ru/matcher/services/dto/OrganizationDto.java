package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;
import ru.matcher.data.model.File;
import ru.matcher.data.model.OrganizationType;

/**
 * Dto класс для организации.
 *
 * @author Николай Евсюков
 */
@Getter
@Setter
public class OrganizationDto {

    private Integer id;
    private File picture;
    private String name;
    private OrganizationType organizationType;
    private String description;
    private String url;
    private String email;
    private String address;
}
