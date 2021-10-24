package ru.matcher.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matcher.services.dto.RequestDto;
import ru.matcher.services.service.IRequestService;

import java.util.List;

/**
 * Контроллер для проектов.
 *
 * @author Максим Щербаков
 */
@RestController
@RequestMapping(
        path = "/request",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class RequestController {
    private final IRequestService requestService;

    @Autowired
    public RequestController(IRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/subscribe")
    public void subscribe(@RequestBody RequestDto requestDto) {
        requestService.create(requestDto);
    }

    @GetMapping("/{projectId}")
    public List<RequestDto> getRequestsByProjectId(@PathVariable Integer projectId) {
        return requestService.getRequestsByProjectId(projectId);
    }

    @GetMapping("/remove/{projectId}")
    public void remove(@PathVariable int projectId) {
        requestService.remove(projectId);
    }

    @GetMapping("/accept/{projectId}")
    public void accept(@PathVariable int projectId) {
        requestService.acceptAndRemove(projectId);
    }

    @GetMapping("check/{userId}/{projectId}")
    public boolean canSubscribe(@PathVariable Integer userId, @PathVariable Integer projectId) {
        return requestService.canSubscribe(userId, projectId);
    }
}
