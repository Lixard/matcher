package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.matcher.data.model.Project;
import ru.matcher.data.model.Request;
import ru.matcher.data.model.User;
import ru.matcher.services.dto.RequestDto;

import java.util.List;

/**
 * Маппер для запросов на присоединение к проекту.
 *
 * @author Максим Щербаков
 */
@Mapper
public interface RequestStruct {

    /**
     * Превращение Request в RequestDto.
     *
     * @param request объект класса Request
     * @return объект класса RequestDto
     */
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "projectId", source = "project.id")
    RequestDto toDto(Request request);

    /**
     * Превращение RequestDto в Organization.
     *
     * @param requestDto объект класса RequestDto
     * @return объект класса Request
     */
    @Mapping(target = "project", source = "projectId", qualifiedByName = "setProjectId")
    @Mapping(target = "user", source = "userId", qualifiedByName = "setUserId")
    Request fromDto(RequestDto requestDto);

    /**
     * Превращение списка Request в список RequestDto.
     *
     * @param requests список Request
     * @return список RequestDto
     */
    List<RequestDto> toDto(List<Request> requests);
    /**
     * Превращение списка RequestDto в список Request.
     *
     * @param requestDtos список RequestDto
     * @return список Request
     */
    List<Request> fromDto(List<RequestDto> requestDtos);

    @Named("setProjectId")
    default Project setProjectId(Integer projectId) {
        if (projectId == null) {
            return null;
        }
        final var project = new Project();
        project.setId(projectId);
        return project;
    }

    @Named("setUserId")
    default User setUserId(Integer userId) {
        if (userId == null) {
            return null;
        }
        final var user = new User();
        user.setId(userId);
        return user;
    }
}
