package ru.matcher.services.service.implementation;

import org.springframework.stereotype.Service;
import ru.matcher.data.model.Organization;
import ru.matcher.data.repository.OrganizationRepository;
import ru.matcher.services.dto.OrganizationDto;
import ru.matcher.services.mapstruct.OrganizationStruct;
import ru.matcher.services.service.OrganizationService;

import java.util.List;

/**
 * Реализация интерфейса OrganizationService.
 *
 * @author Николай Евсюков
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationStruct organizationStruct;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository,
                                   OrganizationStruct organizationStruct) {
        this.organizationRepository = organizationRepository;
        this.organizationStruct = organizationStruct;
    }

    @Override
    public OrganizationDto create(OrganizationDto organizationDto) {
        Organization organization = organizationStruct.fromDto(organizationDto);
        organizationRepository.save(organization);
        return organizationStruct.toDto(organization);
    }

    @Override
    public OrganizationDto update(OrganizationDto organizationDto) {
        Organization organization = organizationStruct.fromDto(organizationDto);
        organizationRepository.save(organization);
        return organizationStruct.toDto(organization);
    }

    @Override
    public void remove(int organizationId) {
        organizationRepository.deleteById(organizationId);
    }

    @Override
    public List<OrganizationDto> getOrganizations() {
        return organizationStruct.toDto(organizationRepository.findAll());
    }

    @Override
    public OrganizationDto findById(int organizationId) {
        return organizationStruct.toDto(organizationRepository.findById(organizationId).get());
    }
}
