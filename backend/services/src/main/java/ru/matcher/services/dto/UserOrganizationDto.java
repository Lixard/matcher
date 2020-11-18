package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;
import ru.matcher.data.model.embedded.UserOrganisationEmbeddedId;

import java.time.LocalDate;

/**
 * Dto класс для организаций пользователя.
 *
 * @author Николай Евсюков
 */
@Getter
@Setter
public class UserOrganizationDto {

    private UserOrganisationEmbeddedId id;
    private Integer userId;
    private Integer organizationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isAdmin;
}
