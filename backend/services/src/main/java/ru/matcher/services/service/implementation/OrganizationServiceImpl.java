package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.commons.OrganizationType;
import ru.matcher.data.model.Organization;
import ru.matcher.data.model.UserOrganization;
import ru.matcher.data.model.embedded.UserOrganizationEmbeddedId;
import ru.matcher.data.repository.OrganizationRepository;
import ru.matcher.data.repository.UserOrganizationRepository;
import ru.matcher.data.repository.UserRepository;
import ru.matcher.services.dto.OrganizationDto;
import ru.matcher.services.dto.UserDto;
import ru.matcher.services.mapstruct.OrganizationStruct;
import ru.matcher.services.mapstruct.UserStruct;
import ru.matcher.services.service.IOrganizationService;

import java.util.List;
import java.util.stream.Collectors;

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
    private final UserStruct userStruct;
    private final UserOrganizationRepository userOrganizationRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository,
                                   OrganizationStruct organizationStruct,
                                   UserStruct userStruct, UserOrganizationRepository userOrganizationRepository, UserRepository userRepository) {
        this.organizationRepository = organizationRepository;
        this.organizationStruct = organizationStruct;
        this.userStruct = userStruct;
        this.userOrganizationRepository = userOrganizationRepository;
        this.userRepository = userRepository;
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
    public List<OrganizationDto> getOrganizationsByUser(int userId) {
        final var organizationIds = userOrganizationRepository.findByIdUser(userId)
                .stream()
                .map(UserOrganization::getId)
                .map(UserOrganizationEmbeddedId::getOrganization)
                .collect(Collectors.toList());

        return organizationRepository.findAllById(organizationIds)
                .stream()
                .map(organizationStruct::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUsersByOrganization(int organizationId) {
        final var userIds = userOrganizationRepository.findByIdOrganization(organizationId)
                .stream()
                .map(UserOrganization::getId)
                .map(UserOrganizationEmbeddedId::getUser)
                .collect(Collectors.toList());

        return userRepository.findAllById(userIds)
                .stream()
                .map(userStruct::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAdmin(Integer userId, Integer orgId) {
        return false;
    }
}
