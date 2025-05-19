package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.model.GenresModel;
import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.SaveGamesTo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-19T10:22:24+0200",
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
    public GamesModel toGamesModel(SaveGamesTo saveGamesTo) {
        if ( saveGamesTo == null ) {
            return null;
        }

        GamesModel gamesModel = new GamesModel();

        gamesModel.setTitle( saveGamesTo.getTitle() );
        gamesModel.setDescription( saveGamesTo.getDescription() );
        gamesModel.setDeveloper( saveGamesTo.getDeveloper() );
        gamesModel.setReleaseDate( saveGamesTo.getReleaseDate() );
        gamesModel.setRating( saveGamesTo.getRating() );
        gamesModel.setGenres( genresNameToListToGenresModelList( saveGamesTo.getGenres() ) );

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

    protected GenresModel genresNameToToGenresModel(GenresNameTo genresNameTo) {
        if ( genresNameTo == null ) {
            return null;
        }

        GenresModel genresModel = new GenresModel();

        return genresModel;
    }

    protected List<GenresModel> genresNameToListToGenresModelList(List<GenresNameTo> list) {
        if ( list == null ) {
            return null;
        }

        List<GenresModel> list1 = new ArrayList<GenresModel>( list.size() );
        for ( GenresNameTo genresNameTo : list ) {
            list1.add( genresNameToToGenresModel( genresNameTo ) );
        }

        return list1;
    }
}
