package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matcher.data.model.Organization;

/**
 * Репозиторий для организаций.
 *
 * @author Николай Евсюков
 */
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
