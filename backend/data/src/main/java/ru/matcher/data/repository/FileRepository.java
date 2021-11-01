package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matcher.data.model.File;

/**
 * Репозиторий для файлов.
 *
 * @author Комов Максим
 */
public interface FileRepository extends JpaRepository<File, Integer> {
}
