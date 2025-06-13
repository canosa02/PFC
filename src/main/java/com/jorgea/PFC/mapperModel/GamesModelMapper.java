package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.to.GamesPostTo;
import com.jorgea.PFC.to.GamesWithoutGenresTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GamesModelMapper {

    GamesWithoutGenresTo toGamesWithoutGenresTo(GamesModel gamesModel);

    GamesModel toGamesModel(GamesPostTo gamesPostTo);


}
