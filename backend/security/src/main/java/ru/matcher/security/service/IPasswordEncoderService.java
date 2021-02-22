package ru.matcher.security.service;

/**
 * Сервис шифрования пароля.
 *
 * @author Maxim Borisov
 */
public interface IPasswordEncoderService {

    /**
     * Метод, позволяющий зашифровать пароль в одностороннем порядке.
     *
     * @param password "сырой" пароль
     * @return зашифрованный пароль
     */
    String encode(final String password);

    /**
     * Метод для сравнивания паролей между собой.
     *
     * @param raw     незашифрованный пароль
     * @param encoded зашифрованный
     * @return результат совпадения: совпадают/не совпадают
     */
    boolean matches(CharSequence raw, String encoded);
}
