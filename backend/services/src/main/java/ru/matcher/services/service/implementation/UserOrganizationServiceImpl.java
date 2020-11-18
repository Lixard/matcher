package ru.matcher.services.service.implementation;

import org.springframework.stereotype.Service;
import ru.matcher.data.model.UserOrganization;
import ru.matcher.data.model.embedded.UserOrganisationEmbeddedId;
import ru.matcher.data.repository.UserOrganizationRepository;
import ru.matcher.services.dto.UserOrganizationDto;
import ru.matcher.services.mapstruct.UserOrganizationStruct;
import ru.matcher.services.service.UserOrganizationService;

import java.util.List;

/**
 * Реализация интерфейса UserOrganizationService.
 *
 * @author Николай Евсюков
 */
@Service
public class UserOrganizationServiceImpl implements UserOrganizationService {

    private final UserOrganizationRepository userOrganizationRepository;
    private final UserOrganizationStruct userOrganizationStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public UserOrganizationServiceImpl(UserOrganizationRepository userOrganizationRepository,
                                       UserOrganizationStruct userOrganizationStruct) {
        this.userOrganizationRepository = userOrganizationRepository;
        this.userOrganizationStruct = userOrganizationStruct;
    }

    @Override
    public UserOrganizationDto createOrUpdate(UserOrganizationDto userOrganizationDto) {
        UserOrganization userOrganization = userOrganizationStruct.fromDto(userOrganizationDto);
        userOrganizationRepository.save(userOrganization);
        return userOrganizationStruct.toDto(userOrganization);
    }

    @Override
    public void remove(UserOrganisationEmbeddedId userOrganizationId) {
        userOrganizationRepository.deleteById(userOrganizationId);
    }

    @Override
    public List<UserOrganizationDto> getUserOrganizations() {
        return userOrganizationStruct.toDto(userOrganizationRepository.findAll());
    }

    @Override
    public UserOrganizationDto findById(UserOrganisationEmbeddedId userOrganizationId) {
        return userOrganizationStruct.toDto(userOrganizationRepository.findById(userOrganizationId).orElseThrow());
    }
}