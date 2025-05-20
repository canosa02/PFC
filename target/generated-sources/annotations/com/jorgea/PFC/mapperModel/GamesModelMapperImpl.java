package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.model.GenresModel;
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
    date = "2025-05-20T16:34:26+0200",
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
        gamesGenresTo.setGenres( genresModelListToGenresNameToList( gamesModel.getGenres() ) );

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

    protected GenresNameTo genresModelToGenresNameTo(GenresModel genresModel) {
        if ( genresModel == null ) {
            return null;
        }

        GenresNameTo genresNameTo = new GenresNameTo();

        return genresNameTo;
    }

    protected List<GenresNameTo> genresModelListToGenresNameToList(List<GenresModel> list) {
        if ( list == null ) {
            return null;
        }

        List<GenresNameTo> list1 = new ArrayList<GenresNameTo>( list.size() );
        for ( GenresModel genresModel : list ) {
            list1.add( genresModelToGenresNameTo( genresModel ) );
        }

        return list1;
    }
}
