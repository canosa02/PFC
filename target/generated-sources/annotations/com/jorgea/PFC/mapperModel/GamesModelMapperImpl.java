package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.model.GenresInGames;
import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.GamesPostTo;
import com.jorgea.PFC.to.GamesWithoutGenresTo;
import com.jorgea.PFC.to.GenresNameTo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-22T12:48:26+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class GamesModelMapperImpl implements GamesModelMapper {

    @Override
    public GamesGenresTo toGamesGenresTo(GamesModel gamesModel) {
        if ( gamesModel == null ) {
            return null;
        }

        GamesGenresTo gamesGenresTo = new GamesGenresTo();

        gamesGenresTo.setGameId( gamesModel.getGameId() );
        gamesGenresTo.setTitle( gamesModel.getTitle() );
        gamesGenresTo.setDescription( gamesModel.getDescription() );
        gamesGenresTo.setDeveloper( gamesModel.getDeveloper() );
        gamesGenresTo.setReleaseDate( gamesModel.getReleaseDate() );
        gamesGenresTo.setRating( gamesModel.getRating() );
        gamesGenresTo.setGenres( genresInGamesListToGenresNameToList( gamesModel.getGenres() ) );

        return gamesGenresTo;
    }

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

    protected GenresNameTo genresInGamesToGenresNameTo(GenresInGames genresInGames) {
        if ( genresInGames == null ) {
            return null;
        }

        GenresNameTo genresNameTo = new GenresNameTo();

        return genresNameTo;
    }

    protected List<GenresNameTo> genresInGamesListToGenresNameToList(List<GenresInGames> list) {
        if ( list == null ) {
            return null;
        }

        List<GenresNameTo> list1 = new ArrayList<GenresNameTo>( list.size() );
        for ( GenresInGames genresInGames : list ) {
            list1.add( genresInGamesToGenresNameTo( genresInGames ) );
        }

        return list1;
    }
}
