package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Modifying
    @Query(value = "update matcher.user_organizations set org_id=:orgId where user_id=:userId", nativeQuery = true)
    void saveByIdUser(@Param("userId") int userId, @Param("orgId") int orgId);
}
