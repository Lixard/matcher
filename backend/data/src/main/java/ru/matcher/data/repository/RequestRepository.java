package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.matcher.data.model.Request;

import java.util.List;

/**
 * Репозиторий для запросов на присоединение к проекту.
 *
 * @author Максим Щербаков
 */
public interface RequestRepository extends JpaRepository<Request, Integer> {
    @Query(value = "select * from matcher.requests where project_id = :projectId", nativeQuery = true)
    List<Request> findByProjectId(@Param("projectId") Integer projectId);

    @Query(value = "select * from matcher.requests where project_id = :projectId and user_id = :userId", nativeQuery = true)
    Request findByProjectIdAndUserId(@Param("projectId") Integer projectId, @Param("userId") Integer userId);
}
