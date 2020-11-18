package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;
import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;

import java.time.LocalDate;

/**
 * Dto класс для пользователей учавствовавших в проектах.
 *
 * @author Николай Евсюков
 */
@Getter
@Setter
public class ProjectParticipationDto {

    private ProjectUserEmbeddedId id;
    private Integer userId;
    private Integer projectId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isAdmin;
}
