package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matcher.data.model.OrganizationType;

/**
 * Репозиторий для типов организаций.
 *
 * @author Николай Евсюков
 */
public interface OrganizationTypeRepository extends JpaRepository<OrganizationType, Integer> {
}
