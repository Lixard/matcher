package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.UserOrganization;
import ru.matcher.data.model.embedded.UserOrganisationEmbeddedId;
import ru.matcher.data.repository.UserOrganizationRepository;
import ru.matcher.services.dto.UserOrganizationDto;
import ru.matcher.services.mapstruct.UserOrganizationStruct;
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

    @Autowired
    public UserOrganizationServiceImpl(UserOrganizationRepository userOrganizationRepository,
                                       UserOrganizationStruct userOrganizationStruct) {
        this.userOrganizationRepository = userOrganizationRepository;
        this.userOrganizationStruct = userOrganizationStruct;
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
    public UserOrganizationDto update(UserOrganizationDto userOrganizationDto) {
        UserOrganization userOrganization = userOrganizationStruct.fromDto(userOrganizationDto);
        userOrganizationRepository.save(userOrganization);
        return userOrganizationStruct.toDto(userOrganization);
    }

    @Override
    @Transactional
    public void remove(UserOrganisationEmbeddedId userOrganizationId) {
        userOrganizationRepository.deleteById(userOrganizationId);
    }

    @Override
    public List<UserOrganizationDto> getUserOrganizations() {
        return userOrganizationStruct.toDto(userOrganizationRepository.findAll());
    }

    @Override
    public UserOrganizationDto findById(UserOrganisationEmbeddedId userOrganizationId) {
        return userOrganizationStruct.toDto(userOrganizationRepository.findById(userOrganizationId).orElse(null));
    }
}
