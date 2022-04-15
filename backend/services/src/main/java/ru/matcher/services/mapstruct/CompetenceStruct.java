package ru.matcher.services.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.matcher.data.model.Competence;
import ru.matcher.services.dto.CompetenceDto;

import java.util.List;

@Mapper
public interface CompetenceStruct {

    CompetenceDto toDto(Competence competence);

    @Mapping(target = "users", ignore = true)
    Competence fromDto(CompetenceDto competenceDto);

    List<CompetenceDto> toDto(List<Competence> competences);

    List<Competence> fromDto(List<CompetenceDto> competenceDtos);
}
