package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;
import ru.matcher.data.model.Organization;
import ru.matcher.data.model.User;
import ru.matcher.data.model.embedded.UserOrganisationEmbeddedId;

import java.time.LocalDate;

@Getter
@Setter
public class UserOrganizationDto {

    private UserOrganisationEmbeddedId id;
    private User user;
    private Organization organization;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isAdmin;
}
