package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.commons.UserType;
import ru.matcher.data.model.User;
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
        final var userBuilder = User.Builder.anUser()
                .withFirstName(dto.getFirstName())
                .withSecondName(dto.getSecondName())
                .withLastName(dto.getLastName())
                .withEmail(dto.getEmail())
                .withLogin(dto.getLogin())
                .withPassword(passwordEncoderService.encode(dto.getPassword()));

        if (Objects.equals(dto.getEmployment(), "Студент")) {
            userBuilder.withUserType(UserType.STUDENT);
        } else {
            userBuilder.withUserType(UserType.EMPLOYEE);
        }

        userRepository.save(userBuilder.build());

        User userDb = userRepository.findByLogin(dto.getLogin()).orElseThrow();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);


        final var userOrganizationBuilder = UserOrganizationDto.Builder.anUserOrganizationDto()
                .withUserId(userDb.getId())
                .withOrganizationId(organizationService.findByName(dto.getPlace()).getId())
                .withStartDate(LocalDate.parse(dto.getStartDate(), formatter))
                .withIsAdmin(dto.isAdmin());

        if (!dto.getEndDate().isBlank()) {
            userOrganizationBuilder.withEndDate(LocalDate.parse(dto.getEndDate(), formatter));
        }

        userOrganizationService.create(userOrganizationBuilder.build());

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
