package ru.matcher.services.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.matcher.data.model.Picture;
import ru.matcher.data.repository.PictureRepository;
import ru.matcher.services.dto.PictureDto;
import ru.matcher.services.mapstruct.PictureStruct;
import ru.matcher.services.service.IPictureService;

import java.io.IOException;
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
    public PictureDto create(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Picture picture = new Picture(fileName, file.getContentType(), file.getBytes());

        pictureRepository.save(picture);
        return pictureStruct.toDto(picture);
    }

    @Override
    public PictureDto update(PictureDto pictureDto) throws IOException {
        Picture picture = pictureStruct.fromDto(pictureDto);

        pictureRepository.save(picture);

        return pictureStruct.toDto(picture);
    }

    @Override
    public void remove(int pictureId) {
        pictureRepository.deleteById(pictureId);
    }

    @Override
    public List<PictureDto> getPictures() {
        return pictureStruct.toDto(pictureRepository.findAll());
    }

    @Override
    public PictureDto findById(int pictureId) {
        return pictureStruct.toDto(pictureRepository.findById(pictureId).orElse(null));
    }
}
