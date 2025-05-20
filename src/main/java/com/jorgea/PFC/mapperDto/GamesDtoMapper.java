package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.GamesDto;
import com.jorgea.PFC.dto.GamesGenresDto;
import com.jorgea.PFC.dto.GamesWithoutGenresDto;
import com.jorgea.PFC.dto.GamesPostDto;
import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.GamesPostTo;
import com.jorgea.PFC.to.GamesTo;
import com.jorgea.PFC.to.GamesWithoutGenresTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GamesDtoMapper {

    GamesDto toGamesDto(GamesTo gamesTo);

    GamesTo toGamesTo(GamesDto gamesDto);

    GamesGenresDto toGamesGenresDto(GamesGenresTo gamesGenresTo);

    GamesPostTo toSaveGamesTo(GamesPostDto gamesPostDto);

    GamesWithoutGenresDto toGamesWithoutGenresDto(GamesWithoutGenresTo gamesWithoutGenresTo);

}
