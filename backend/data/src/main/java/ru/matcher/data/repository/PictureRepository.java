package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matcher.data.model.Picture;

/**
 * Репозиторий для картинок.
 *
 * @author Николай Евсюков
 */
public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
