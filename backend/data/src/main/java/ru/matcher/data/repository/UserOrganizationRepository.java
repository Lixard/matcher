package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matcher.data.model.UserOrganization;
import ru.matcher.data.model.embedded.UserOrganisationEmbeddedId;

/**
 * Репозиторий для организаций пользователя.
 *
 * @author Николай Евсюков
 */
public interface UserOrganizationRepository extends JpaRepository<UserOrganization, UserOrganisationEmbeddedId> {
}
