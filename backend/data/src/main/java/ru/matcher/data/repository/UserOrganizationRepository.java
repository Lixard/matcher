package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matcher.data.model.UserOrganization;
import ru.matcher.data.model.embedded.UserOrganizationEmbeddedId;

import java.util.List;

/**
 * Репозиторий для организаций пользователя.
 *
 * @author Николай Евсюков
 */
public interface UserOrganizationRepository extends JpaRepository<UserOrganization, UserOrganizationEmbeddedId> {

    List<UserOrganization> findByIdUser(int userId);
}
