package ru.matcher.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matcher.data.model.Competence;
import ru.matcher.data.model.User;

import java.util.List;
import java.util.Optional;

public interface CompetenceRepository extends JpaRepository<Competence, Integer> {

    Optional<Competence> findByNameIgnoreCase(String name);

    List<Competence> findAllByUsersIs(User user);
}
