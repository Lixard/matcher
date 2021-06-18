package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.commons.UserType;
import ru.matcher.data.model.User;
import ru.matcher.data.model.embedded.UserOrganisationEmbeddedId;
import ru.matcher.data.repository.UserRepository;
import ru.matcher.security.service.IPasswordEncoderService;
import ru.matcher.services.dto.UserDto;
import ru.matcher.services.dto.UserOrganizationDto;
import ru.matcher.services.dto.create.UserCreateDto;
import ru.matcher.services.mapstruct.UserStruct;
import ru.matcher.services.service.IOrganizationService;
import ru.matcher.services.service.IUserOrganizationService;
import ru.matcher.services.service.IUserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * Реализация интерфейса UserService.
 *
 * @author Николай Евсюков
 * @author Максим Щербаков
 */
@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserStruct userStruct;
    private final IPasswordEncoderService passwordEncoderService;
    private final IUserOrganizationService userOrganizationService;
    private final IOrganizationService organizationService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserStruct userStruct,
                           IPasswordEncoderService passwordEncoderService,
                           IUserOrganizationService userOrganizationService, IOrganizationService organizationService) {
        this.userRepository = userRepository;
        this.userStruct = userStruct;
        this.passwordEncoderService = passwordEncoderService;
        this.userOrganizationService = userOrganizationService;
        this.organizationService = organizationService;
    }

    @Override
    @Transactional
    public UserDto create(UserCreateDto dto) {
        final var user = userStruct.fromDto(dto);
        user.setFirstName(dto.getFirstName());
        user.setSecondName(dto.getSecondName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setLogin(dto.getLogin());
        user.setPassword(passwordEncoderService.encode(dto.getPassword()));
        if (Objects.equals(dto.getEmployment(), "Студент")) {
            user.setUserType(UserType.STUDENT);
        } else {
            user.setUserType(UserType.EMPLOYEE);
        }
        userRepository.save(user);
        System.out.println(dto.getPlace());
        User userDb = userRepository.findByLogin(dto.getLogin()).orElse(null);
        if (userDb != null) {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);


            UserOrganizationDto userOrganizationDto = new UserOrganizationDto();
            userOrganizationDto.setStartDate(LocalDate.parse(dto.getStartDate(), formatter));
            userOrganizationDto.setUserId(userDb.getId());
            userOrganizationDto.setOrganizationId(organizationService.findByName(dto.getPlace()).getId());

            UserOrganisationEmbeddedId userOrganisationEmbeddedId = new UserOrganisationEmbeddedId();
            userOrganisationEmbeddedId.setUser(userDb.getId());
            userOrganisationEmbeddedId.setOrganization(organizationService.findByName(dto.getPlace()).getId());
            userOrganizationDto.setId(userOrganisationEmbeddedId);

            if (!dto.getEndDate().isBlank()) {
                userOrganizationDto.setEndDate(LocalDate.parse(dto.getEndDate(), formatter));
            }

            userOrganizationDto.setAdmin(dto.isAdmin());
            userOrganizationService.create(userOrganizationDto);
        }

        return userStruct.toDto(user);
    }

    @Override
    @Transactional
    public UserDto update(UserDto userDto) {
        User user = userStruct.fromDto(userDto);
        userRepository.save(user);
        return userStruct.toDto(user);
    }

    @Override
    @Transactional
    public void remove(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> getUsers() {
        return userStruct.toDto(userRepository.findAll());
    }

    @Override
    public UserDto findById(int userId) {
        return userStruct.toDto(userRepository.findById(userId).orElse(null));
    }
}
