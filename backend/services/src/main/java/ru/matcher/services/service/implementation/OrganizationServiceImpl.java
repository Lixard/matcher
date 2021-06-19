package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.commons.OrganizationType;
import ru.matcher.data.model.Organization;
import ru.matcher.data.repository.OrganizationRepository;
import ru.matcher.services.dto.OrganizationDto;
import ru.matcher.services.mapstruct.OrganizationStruct;
import ru.matcher.services.service.IOrganizationService;

import java.util.List;

/**
 * Реализация интерфейса OrganizationService.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
 */
@Service
public class OrganizationServiceImpl implements IOrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationStruct organizationStruct;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository,
                                   OrganizationStruct organizationStruct) {
        this.organizationRepository = organizationRepository;
        this.organizationStruct = organizationStruct;
    }

    @Override
    @Transactional
    public OrganizationDto create(OrganizationDto organizationDto) {
        Organization organization = organizationStruct.fromDto(organizationDto);
        organizationRepository.save(organization);
        return organizationStruct.toDto(organization);
    }

    @Override
    @Transactional
    public OrganizationDto update(OrganizationDto organizationDto) {
        Organization organization = organizationStruct.fromDto(organizationDto);
        organizationRepository.save(organization);
        return organizationStruct.toDto(organization);
    }

    @Override
    @Transactional
    public void remove(int organizationId) {
        organizationRepository.deleteById(organizationId);
    }

    @Override
    public List<OrganizationDto> getOrganizations() {
        return organizationStruct.toDto(organizationRepository.findAll());
    }

    @Override
    public OrganizationDto findById(int organizationId) {
        return organizationStruct.toDto(organizationRepository.findById(organizationId).orElse(null));
    }

    @Override
    public List<OrganizationDto> findByOrganizationType(Integer organizationType) {
        if (organizationType == 1) {
            return organizationStruct.toDto(organizationRepository.findByOrganizationType(OrganizationType.UNIVERSITY));
        } else {
            return organizationStruct.toDto(organizationRepository.findByOrganizationType(OrganizationType.COMPANY));
        }
    }

    @Override
    public OrganizationDto findByName(String name) {
        return organizationStruct.toDto(organizationRepository.findByName(name));
    }

    @Override
    public boolean isAdmin(Integer userId, Integer orgId) {
        return false;
    }
}
