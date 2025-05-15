package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.dto.FilmsGenresDto;
import com.jorgea.PFC.to.FilmsGenresTo;
import com.jorgea.PFC.to.FilmsTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmsDtoMapper {

    FilmsDto toFilmsDto(FilmsTo filmsTo);

    FilmsTo toFilmsTo(FilmsDto filmsDto);

    FilmsGenresDto toFilmsGenresDto(FilmsGenresTo filmsGenresTo);

    FilmsGenresTo toFilmsGenresTo(FilmsGenresDto filmsGenresDto);
}
