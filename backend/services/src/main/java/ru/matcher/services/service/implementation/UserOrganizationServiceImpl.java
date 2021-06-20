package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.UserOrganization;
import ru.matcher.data.model.embedded.UserOrganizationEmbeddedId;
import ru.matcher.data.repository.UserOrganizationRepository;
import ru.matcher.services.dto.OrganizationDto;
import ru.matcher.services.dto.UserOrganizationDto;
import ru.matcher.services.dto.update.UserOrganizationUpdate;
import ru.matcher.services.mapstruct.UserOrganizationStruct;
import ru.matcher.services.service.IOrganizationService;
import ru.matcher.services.service.IUserOrganizationService;

import java.util.List;

/**
 * Реализация интерфейса UserOrganizationService.
 *
 * @author Николай Евсюков
 */
@Service
public class UserOrganizationServiceImpl implements IUserOrganizationService {

    private final UserOrganizationRepository userOrganizationRepository;
    private final UserOrganizationStruct userOrganizationStruct;
    private final IOrganizationService organizationService;

    @Autowired
    public UserOrganizationServiceImpl(UserOrganizationRepository userOrganizationRepository,
                                       UserOrganizationStruct userOrganizationStruct, IOrganizationService organizationService) {
        this.userOrganizationRepository = userOrganizationRepository;
        this.userOrganizationStruct = userOrganizationStruct;
        this.organizationService = organizationService;
    }

    @Override
    @Transactional
    public UserOrganizationDto create(UserOrganizationDto userOrganizationDto) {
        UserOrganization userOrganization = userOrganizationStruct.fromDto(userOrganizationDto);
        userOrganizationRepository.save(userOrganization);
        return userOrganizationStruct.toDto(userOrganization);
    }

    @Override
    @Transactional
    public UserOrganizationDto update(UserOrganizationUpdate userOrganizationUpdate) {
        OrganizationDto organizationDto = organizationService.findByName(userOrganizationUpdate.getPlace());
        List<UserOrganization> userOrganizations = userOrganizationRepository.findByIdUser(userOrganizationUpdate.getUserId());
        UserOrganization userOrganization = userOrganizations.get(0);
        userOrganization.getId().setOrganization(organizationDto.getId());
        userOrganizationRepository.saveByIdUser(userOrganizationUpdate.getUserId(),
                                                    organizationDto.getId());

        return userOrganizationStruct.toDto(userOrganization);
    }

    @Override
    @Transactional
    public void remove(UserOrganizationEmbeddedId userOrganizationId) {
        userOrganizationRepository.deleteById(userOrganizationId);
    }

    @Override
    public List<UserOrganizationDto> getUserOrganizations() {
        return userOrganizationStruct.toDto(userOrganizationRepository.findAll());
    }

    @Override
    public UserOrganizationDto findById(UserOrganizationEmbeddedId userOrganizationId) {
        return userOrganizationStruct.toDto(userOrganizationRepository.findById(userOrganizationId).orElse(null));
    }
}
