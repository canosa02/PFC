package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.to.FilmsTo;
import org.mapstruct.Mapper;

@Mapper
public interface FilmsDtoMapper {

    FilmsDto toFilmsDto(FilmsTo filmsTo);

    FilmsTo toFilmsTo(FilmsDto filmsDto);
}
