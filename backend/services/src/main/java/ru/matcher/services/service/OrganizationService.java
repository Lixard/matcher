package ru.matcher.services.service;

import ru.matcher.services.dto.OrganizationDto;

import java.util.List;

public interface OrganizationService {

    OrganizationDto createOrUpdate(OrganizationDto organizationDto);

    void remove(int organizationId);

    List<OrganizationDto> getOrganizations();

    OrganizationDto findById(int organizationId);
}
