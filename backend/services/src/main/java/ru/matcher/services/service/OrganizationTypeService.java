package ru.matcher.services.service;

import ru.matcher.services.dto.OrganizationTypeDto;

import java.util.List;

public interface OrganizationTypeService {

    OrganizationTypeDto createOrUpdate(OrganizationTypeDto organizationTypeDto);

    void remove(int organizationTypeId);

    List<OrganizationTypeDto> getOrganizationTypes();

    OrganizationTypeDto findById(int organizationTypeId);
}
