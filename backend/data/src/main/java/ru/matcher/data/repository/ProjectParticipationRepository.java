package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matcher.data.model.ProjectParticipation;
import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;

/**
 * Репозиторий для пользователей учавствовавших в проектах.
 *
 * @author Николай Евсюков
 */
public interface ProjectParticipationRepository extends JpaRepository<ProjectParticipation, ProjectUserEmbeddedId> {
}
