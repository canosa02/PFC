package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.GenresDto;
import com.jorgea.PFC.to.GenresTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenresDtoMapper {

    GenresTo toGenresTo(GenresDto genresDto);

    GenresDto toGenresDto(GenresTo genresTo);



}
