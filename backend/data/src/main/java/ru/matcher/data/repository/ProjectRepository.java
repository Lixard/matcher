package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.matcher.data.model.Project;

import java.util.List;

/**
 * Репозиторий для проектов.
 *
 * @author Николай Евсюков
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query(value = "select * from matcher.projects where org_id = :orgId", nativeQuery = true)
    List<Project> findProjectByOrganization(@Param("orgId") int orgId);
}
