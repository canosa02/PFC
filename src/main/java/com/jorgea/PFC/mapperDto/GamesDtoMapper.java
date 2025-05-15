package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.GamesDto;
import com.jorgea.PFC.dto.GamesGenresDto;
import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.GamesTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GamesDtoMapper {

    GamesDto toGamesDto(GamesTo gamesTo);

    GamesTo toGamesTo(GamesDto gamesDto);

    GamesGenresDto toGamesGenresDto(GamesGenresTo gamesGenresTo);

}
