package ru.matcher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matcher.security.mapper.CurrentUserMapper;
import ru.matcher.security.model.CurrentUserDto;
import ru.matcher.security.model.ICurrentUser;

@RestController
@RequestMapping(
        path = "/auth",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AuthController {

    private final ICurrentUser currentUser;
    private final CurrentUserMapper mapper;

    @Autowired
    public AuthController(ICurrentUser currentUser, CurrentUserMapper mapper) {
        this.currentUser = currentUser;
        this.mapper = mapper;
    }

    @GetMapping("/this")
    public CurrentUserDto getCurrentUser() {
        return mapper.toDto(currentUser);
    }
}
