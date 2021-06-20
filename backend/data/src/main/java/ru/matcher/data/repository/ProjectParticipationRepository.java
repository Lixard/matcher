package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.matcher.data.model.ProjectParticipation;
import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;

import java.util.List;

/**
 * Репозиторий для пользователей учавствовавших в проектах.
 *
 * @author Николай Евсюков
 */
public interface ProjectParticipationRepository extends JpaRepository<ProjectParticipation, ProjectUserEmbeddedId> {
    @Modifying
    @Query(value = "select * from matcher.project_participation where project_id =:projectId", nativeQuery = true)
    List<ProjectParticipation> findByProjectId(@Param("projectId") int projectId);
}
