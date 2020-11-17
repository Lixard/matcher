package ru.matcher.services.service.implementation;

import org.springframework.stereotype.Service;
import ru.matcher.data.model.OrganizationType;
import ru.matcher.data.repository.OrganizationTypeRepository;
import ru.matcher.services.dto.OrganizationTypeDto;
import ru.matcher.services.mapstruct.OrganizationTypeStruct;
import ru.matcher.services.service.OrganizationTypeService;

import java.util.List;

/**
 * Реализация интерфейса OrganizationTypeService.
 *
 * @author Николай Евсюков
 */
@Service
public class OrganizationTypeServiceImpl implements OrganizationTypeService {

    private final OrganizationTypeRepository organizationTypeRepository;
    private final OrganizationTypeStruct organizationTypeStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public OrganizationTypeServiceImpl(OrganizationTypeRepository organizationTypeRepository,
                                       OrganizationTypeStruct organizationTypeStruct) {
        this.organizationTypeRepository = organizationTypeRepository;
        this.organizationTypeStruct = organizationTypeStruct;
    }

    @Override
    public OrganizationTypeDto createOrUpdate(OrganizationTypeDto organizationTypeDto) {
        OrganizationType organizationType = organizationTypeStruct.fromDto(organizationTypeDto);
        organizationTypeRepository.save(organizationType);
        return organizationTypeStruct.toDto(organizationType);
    }

    @Override
    public void remove(int organizationTypeId) {
        organizationTypeRepository.deleteById(organizationTypeId);
    }

    @Override
    public List<OrganizationTypeDto> getOrganizationTypes() {
        return organizationTypeStruct.toDto(organizationTypeRepository.findAll());
    }

    @Override
    public OrganizationTypeDto findById(int organizationTypeId) {
        return organizationTypeStruct.toDto(organizationTypeRepository.findById(organizationTypeId).orElseThrow());
    }
}
