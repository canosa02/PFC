package com.jorgea.PFC.mapper;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.model.FilmsModel;
import org.mapstruct.Mapper;

@Mapper
public interface FilmsMapper {

    FilmsDto toFilmsDto(FilmsModel filmsModel);

    FilmsModel toFilmsModel(FilmsDto filmsDto);
}
