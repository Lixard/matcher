package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.matcher.data.model.File;

import java.util.List;

/**
 * Репозиторий для файлов.
 *
 * @author Комов Максим
 */
public interface FileRepository extends JpaRepository<File, Integer> {

    @Query(value = "select * from matcher.files where file_id in " +
            "(select file_id from matcher.project_files where project_id =:projectId);", nativeQuery = true)
    List<File> findFilesByProject(@Param("projectId") int projectId);

    @Modifying
    @Query(value = "insert into matcher.project_files (project_id, file_id) values (:projectId, :fileId);", nativeQuery = true)
    void insertProjectFile(@Param("projectId") int projectId, @Param("fileId") int fileId);

}
