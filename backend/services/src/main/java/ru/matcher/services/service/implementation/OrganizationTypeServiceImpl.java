package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.OrganizationType;
import ru.matcher.data.repository.OrganizationTypeRepository;
import ru.matcher.services.dto.OrganizationTypeDto;
import ru.matcher.services.mapstruct.OrganizationTypeStruct;
import ru.matcher.services.service.IOrganizationTypeService;

import java.util.List;

/**
 * Реализация интерфейса OrganizationTypeService.
 *
 * @author Николай Евсюков
 */
@Service
public class OrganizationTypeServiceImpl implements IOrganizationTypeService {

    private final OrganizationTypeRepository organizationTypeRepository;
    private final OrganizationTypeStruct organizationTypeStruct;

    @Autowired
    public OrganizationTypeServiceImpl(OrganizationTypeRepository organizationTypeRepository,
                                       OrganizationTypeStruct organizationTypeStruct) {
        this.organizationTypeRepository = organizationTypeRepository;
        this.organizationTypeStruct = organizationTypeStruct;
    }

    @Override
    @Transactional
    public OrganizationTypeDto create(OrganizationTypeDto organizationTypeDto) {
        OrganizationType organizationType = organizationTypeStruct.fromDto(organizationTypeDto);
        organizationTypeRepository.save(organizationType);
        return organizationTypeStruct.toDto(organizationType);
    }

    @Override
    @Transactional
    public OrganizationTypeDto update(OrganizationTypeDto organizationTypeDto) {
        OrganizationType organizationType = organizationTypeStruct.fromDto(organizationTypeDto);
        organizationTypeRepository.save(organizationType);
        return organizationTypeStruct.toDto(organizationType);
    }

    @Override
    @Transactional
    public void remove(int organizationTypeId) {
        organizationTypeRepository.deleteById(organizationTypeId);
    }

    @Override
    public List<OrganizationTypeDto> getOrganizationTypes() {
        return organizationTypeStruct.toDto(organizationTypeRepository.findAll());
    }

    @Override
    public OrganizationTypeDto findById(int organizationTypeId) {
        return organizationTypeStruct.toDto(organizationTypeRepository.findById(organizationTypeId).orElse(null));
    }
}
