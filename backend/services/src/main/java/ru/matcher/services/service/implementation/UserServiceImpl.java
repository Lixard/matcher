package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.User;
import ru.matcher.data.repository.UserRepository;
import ru.matcher.security.service.IPasswordEncoderService;
import ru.matcher.services.dto.UserDto;
import ru.matcher.services.dto.create.UserCreateDto;
import ru.matcher.services.mapstruct.UserStruct;
import ru.matcher.services.service.IUserService;

import java.util.List;

/**
 * Реализация интерфейса UserService.
 *
 * @author Николай Евсюков
 */
@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserStruct userStruct;
    private final IPasswordEncoderService passwordEncoderService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserStruct userStruct,
                           IPasswordEncoderService passwordEncoderService) {
        this.userRepository = userRepository;
        this.userStruct = userStruct;
        this.passwordEncoderService = passwordEncoderService;
    }

    @Override
    @Transactional
    public UserDto create(UserCreateDto dto) {
        final var user = userStruct.fromDto(dto);
        user.setLogin(dto.getLogin());
        user.setPassword(passwordEncoderService.encode(dto.getPassword()));
        userRepository.save(user);
        return userStruct.toDto(user);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userStruct.fromDto(userDto);
        userRepository.save(user);
        return userStruct.toDto(user);
    }

    @Override
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
