package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.to.GamesTo;
import com.jorgea.PFC.to.SaveGamesTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GamesModelMapper {

    GamesTo toGamesTo(GamesModel gamesModel);

    GamesModel toGamesModel(SaveGamesTo saveGamesTo);


}
