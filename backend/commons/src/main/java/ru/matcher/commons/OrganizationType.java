package ru.matcher.commons;

import java.util.Optional;

/**
 * Перечисление для хранения типа организации.
 *
 * @author Максим Щербаков
 */
public enum OrganizationType {
    UNIVERSITY(1),
    COMPANY(2);

    private final int id;

    OrganizationType(int id) {
        this.id = id;
    }

    public static Optional<OrganizationType> fromId(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        for (final OrganizationType type : OrganizationType.values()) {
            if (id.equals(type.getId())) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    public Integer getId() {
        return id;
    }
}
