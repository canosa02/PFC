package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.to.GamesPostTo;
import com.jorgea.PFC.to.GamesWithoutGenresTo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-13T10:16:27+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class GamesModelMapperImpl implements GamesModelMapper {

    @Override
    public GamesWithoutGenresTo toGamesWithoutGenresTo(GamesModel gamesModel) {
        if ( gamesModel == null ) {
            return null;
        }

        GamesWithoutGenresTo gamesWithoutGenresTo = new GamesWithoutGenresTo();

        gamesWithoutGenresTo.setGameId( gamesModel.getGameId() );
        gamesWithoutGenresTo.setTitle( gamesModel.getTitle() );
        gamesWithoutGenresTo.setDescription( gamesModel.getDescription() );
        gamesWithoutGenresTo.setDeveloper( gamesModel.getDeveloper() );
        gamesWithoutGenresTo.setReleaseDate( gamesModel.getReleaseDate() );
        gamesWithoutGenresTo.setRating( gamesModel.getRating() );

        return gamesWithoutGenresTo;
    }

    @Override
    public GamesModel toGamesModel(GamesPostTo gamesPostTo) {
        if ( gamesPostTo == null ) {
            return null;
        }

        GamesModel gamesModel = new GamesModel();

        gamesModel.setTitle( gamesPostTo.getTitle() );
        gamesModel.setDescription( gamesPostTo.getDescription() );
        gamesModel.setDeveloper( gamesPostTo.getDeveloper() );
        gamesModel.setReleaseDate( gamesPostTo.getReleaseDate() );
        gamesModel.setRating( gamesPostTo.getRating() );

        return gamesModel;
    }
}
