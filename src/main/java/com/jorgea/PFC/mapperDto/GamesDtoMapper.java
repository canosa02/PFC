package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.*;
import com.jorgea.PFC.to.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GamesDtoMapper {

    GamesGenresDto toGamesGenresDto(GamesGenresTo gamesGenresTo);

    GamesPostTo toGamesPostTo(GamesPostDto gamesPostDto);

    GamesWithoutGenresDto toGamesWithoutGenresDto(GamesWithoutGenresTo gamesWithoutGenresTo);

    GamesPutTo toGamesPutTo(GamesPutDto gamesPutDto);

    GamesPatchTo toGamesPatchTo(GamesPatchDto gamesPatchDto);

    GamesWithReviewsDto toGamesWithReviewsDto(GamesWithReviewsTo gamesWithReviewsTo);

}
