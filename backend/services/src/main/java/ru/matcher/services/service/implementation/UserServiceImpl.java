package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.matcher.data.model.User;
import ru.matcher.data.repository.UserRepository;
import ru.matcher.services.dto.UserDto;
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

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserStruct userStruct) {
        this.userRepository = userRepository;
        this.userStruct = userStruct;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = userStruct.fromDto(userDto);
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
