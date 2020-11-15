package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matcher.data.model.Project;

/**
 * Репозиторий для проектов.
 *
 * @author Николай Евсюков
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
