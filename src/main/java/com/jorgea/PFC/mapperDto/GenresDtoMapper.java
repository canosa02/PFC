package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.GenresDto;
import com.jorgea.PFC.dto.GenresNameDto;
import com.jorgea.PFC.dto.GenresWithoutGamesDto;
import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.GenresTo;
import com.jorgea.PFC.to.GenresWithoutGamesTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenresDtoMapper {

    GenresTo toGenresTo(GenresDto genresDto);

    GenresNameTo toGenresNameTo(GenresNameDto genresNameDto);

    GenresWithoutGamesDto toGenresWithoutGamesDto(GenresWithoutGamesTo genresWithoutGamesTo);
}
