package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.model.GenresModel;
import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.GenresWithoutGamesTo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenresModelMapper {
    GenresModel toGenresModel(GenresNameTo genresNameTo);

    List<GenresModel> toGenresModelList(List<GenresNameTo> genresNameToList);

    GenresWithoutGamesTo toGenresWithoutGamesTo(GenresModel genresModel);
}
