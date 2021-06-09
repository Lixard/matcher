package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matcher.commons.OrganizationType;
import ru.matcher.data.model.Organization;

import java.util.List;

/**
 * Репозиторий для организаций.
 *
 * @author Николай Евсюков
 */
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    List<Organization> findByOrganizationType(OrganizationType organizationType);
}
