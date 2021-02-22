package ru.matcher.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.matcher.security.service.IPasswordEncoderService;

/**
 * Реализация сервиса {@link IPasswordEncoderService}.
 *
 * @author Maxim Borisov
 */
@Service
public class PasswordEncoderServiceImpl implements IPasswordEncoderService {

    private final PasswordEncoder passwordEncoder;

    /**
     * Конструктор.
     */
    @Autowired
    public PasswordEncoderServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean matches(CharSequence raw, String encoded) {
        return passwordEncoder.matches(raw, encoded);
    }
}
