package ru.matcher.services.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matcher.data.model.Request;
import ru.matcher.data.repository.RequestRepository;
import ru.matcher.services.dto.ProjectParticipationDto;
import ru.matcher.services.dto.RequestDto;
import ru.matcher.services.mapstruct.RequestStruct;
import ru.matcher.services.service.IProjectParticipationService;
import ru.matcher.services.service.IRequestService;

import java.time.LocalDate;
import java.util.List;

/**
 * Реализация интерфейса RequestService.
 *
 * @author Максим Щербаков
 */

@Service
public class RequestServiceImpl implements IRequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);
    private final RequestRepository requestRepository;
    private final RequestStruct requestStruct;
    private final IProjectParticipationService projectParticipationService;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository, RequestStruct requestStruct, IProjectParticipationService projectParticipationService) {
        this.requestRepository = requestRepository;
        this.requestStruct = requestStruct;
        this.projectParticipationService = projectParticipationService;
    }

    @Override
    @Transactional
    public RequestDto create(RequestDto requestDto) {
        Request request = requestStruct.fromDto(requestDto);
        requestRepository.save(request);
        return requestStruct.toDto(request);
    }

    @Override
    @Transactional
    public void remove(int requestId) {
        requestRepository.deleteById(requestId);
    }

    @Override
    @Transactional
    public void acceptAndRemove(int requestId) {
        RequestDto requestDto = requestStruct.toDto(requestRepository.findById(requestId).orElse(null));
        final var projectParticipationBuilder = ProjectParticipationDto.Builder.aProjectParticipationDto()
                .withProjectId(requestDto.getProjectId())
                .withUserId(requestDto.getUserId())
                .withStartDate(LocalDate.now())
                .withIsAdmin(false)
                .withUserRole("Участник");
        logger.info("User(id = {}) subscribes to project(id = {})", requestDto.getUserId(), requestDto.getProjectId());
        projectParticipationService.create(projectParticipationBuilder.build());
        requestRepository.deleteById(requestId);
    }

    @Override
    public List<RequestDto> getRequestsByProjectId(Integer projectId) {
        return requestStruct.toDto(requestRepository.findByProjectId(projectId));
    }

    @Override
    public boolean canSubscribe(Integer userId, Integer projectId) {
        Request request = requestRepository.findByProjectIdAndUserId(projectId, userId);
        return request == null;
    }
}
