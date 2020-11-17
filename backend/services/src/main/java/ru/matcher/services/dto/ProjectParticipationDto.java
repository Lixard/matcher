package ru.matcher.services.dto;

import lombok.Getter;
import lombok.Setter;
import ru.matcher.data.model.Project;
import ru.matcher.data.model.User;
import ru.matcher.data.model.embedded.ProjectUserEmbeddedId;

import java.time.LocalDate;

@Getter
@Setter
public class ProjectParticipationDto {

    private ProjectUserEmbeddedId id;
    private User user;
    private Project project;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isAdmin;
}
