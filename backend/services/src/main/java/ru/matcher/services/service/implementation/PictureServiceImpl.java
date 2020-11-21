package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.matcher.data.model.Picture;
import ru.matcher.data.repository.PictureRepository;
import ru.matcher.services.dto.PictureDto;
import ru.matcher.services.mapstruct.PictureStruct;
import ru.matcher.services.service.IPictureService;

import java.util.List;

/**
 * Реализация интерфейса PictureService.
 *
 * @author Николай Евсюков
 */
@Service
public class PictureServiceImpl implements IPictureService {

    private final PictureRepository pictureRepository;
    private final PictureStruct pictureStruct;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository,
                              PictureStruct pictureStruct) {
        this.pictureRepository = pictureRepository;
        this.pictureStruct = pictureStruct;
    }

    @Override
    public PictureDto create(PictureDto pictureDto) {
        Picture picture = pictureStruct.fromDto(pictureDto);
        pictureRepository.save(picture);
        return pictureStruct.toDto(picture);
    }

    @Override
    public PictureDto update(PictureDto pictureDto) {
        Picture picture = pictureStruct.fromDto(pictureDto);
        pictureRepository.save(picture);
        return pictureStruct.toDto(picture);
    }

    @Override
    public void remove(int fileId) {
        pictureRepository.deleteById(fileId);
    }

    @Override
    public List<PictureDto> getFiles() {
        return pictureStruct.toDto(pictureRepository.findAll());
    }

    @Override
    public PictureDto findById(int fileId) {
        return pictureStruct.toDto(pictureRepository.findById(fileId).orElse(null));
    }
}
