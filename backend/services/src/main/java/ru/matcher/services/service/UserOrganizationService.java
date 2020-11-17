package ru.matcher.services.service;

import ru.matcher.data.model.embedded.UserOrganisationEmbeddedId;
import ru.matcher.services.dto.UserOrganizationDto;

import java.util.List;

public interface UserOrganizationService {

    UserOrganizationDto createOrUpdate(UserOrganizationDto userOrganizationDto);

    void remove(UserOrganisationEmbeddedId userOrganizationId);

    List<UserOrganizationDto> getUserOrganizations();

    UserOrganizationDto findById(UserOrganisationEmbeddedId userOrganizationId);
}
