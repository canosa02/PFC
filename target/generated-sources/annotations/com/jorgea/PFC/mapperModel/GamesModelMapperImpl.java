package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.dto.GamesDto;
import com.jorgea.PFC.dto.GenresDto;
import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.model.GenresModel;
import com.jorgea.PFC.to.GamesTo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-15T20:06:14+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class GamesModelMapperImpl implements GamesModelMapper {

    @Override
    public GamesTo toGamesTo(GamesModel gamesModel) {
        if ( gamesModel == null ) {
            return null;
        }

        GamesTo gamesTo = new GamesTo();

        gamesTo.setTitle( gamesModel.getTitle() );
        gamesTo.setDescription( gamesModel.getDescription() );
        gamesTo.setDeveloper( gamesModel.getDeveloper() );
        gamesTo.setReleaseDate( gamesModel.getReleaseDate() );
        gamesTo.setRating( gamesModel.getRating() );
        gamesTo.setGenres( genresModelListToGenresDtoList( gamesModel.getGenres() ) );

        return gamesTo;
    }

    @Override
    public GamesModel toGamesModel(GamesTo gamesTo) {
        if ( gamesTo == null ) {
            return null;
        }

        GamesModel gamesModel = new GamesModel();

        gamesModel.setTitle( gamesTo.getTitle() );
        gamesModel.setDescription( gamesTo.getDescription() );
        gamesModel.setDeveloper( gamesTo.getDeveloper() );
        gamesModel.setReleaseDate( gamesTo.getReleaseDate() );
        gamesModel.setRating( gamesTo.getRating() );
        gamesModel.setGenres( genresDtoListToGenresModelList( gamesTo.getGenres() ) );

        return gamesModel;
    }

    protected GamesDto gamesModelToGamesDto(GamesModel gamesModel) {
        if ( gamesModel == null ) {
            return null;
        }

        GamesDto gamesDto = new GamesDto();

        gamesDto.setFilmId( gamesModel.getGameId() );
        gamesDto.setTitle( gamesModel.getTitle() );
        gamesDto.setDescription( gamesModel.getDescription() );
        gamesDto.setReleaseDate( gamesModel.getReleaseDate() );
        gamesDto.setRating( gamesModel.getRating() );
        gamesDto.setGenres( genresModelListToGenresDtoList( gamesModel.getGenres() ) );

        return gamesDto;
    }

    protected List<GamesDto> gamesModelListToGamesDtoList(List<GamesModel> list) {
        if ( list == null ) {
            return null;
        }

        List<GamesDto> list1 = new ArrayList<GamesDto>( list.size() );
        for ( GamesModel gamesModel : list ) {
            list1.add( gamesModelToGamesDto( gamesModel ) );
        }

        return list1;
    }

    protected GenresDto genresModelToGenresDto(GenresModel genresModel) {
        if ( genresModel == null ) {
            return null;
        }

        GenresDto genresDto = new GenresDto();

        genresDto.setGenresId( genresModel.getGenresId() );
        genresDto.setGenreName( genresModel.getGenreName() );
        genresDto.setGames( gamesModelListToGamesDtoList( genresModel.getGames() ) );

        return genresDto;
    }

    protected List<GenresDto> genresModelListToGenresDtoList(List<GenresModel> list) {
        if ( list == null ) {
            return null;
        }

        List<GenresDto> list1 = new ArrayList<GenresDto>( list.size() );
        for ( GenresModel genresModel : list ) {
            list1.add( genresModelToGenresDto( genresModel ) );
        }

        return list1;
    }

    protected GamesModel gamesDtoToGamesModel(GamesDto gamesDto) {
        if ( gamesDto == null ) {
            return null;
        }

        GamesModel gamesModel = new GamesModel();

        gamesModel.setGameId( gamesDto.getFilmId() );
        gamesModel.setTitle( gamesDto.getTitle() );
        gamesModel.setDescription( gamesDto.getDescription() );
        gamesModel.setReleaseDate( gamesDto.getReleaseDate() );
        gamesModel.setRating( gamesDto.getRating() );
        gamesModel.setGenres( genresDtoListToGenresModelList( gamesDto.getGenres() ) );

        return gamesModel;
    }

    protected List<GamesModel> gamesDtoListToGamesModelList(List<GamesDto> list) {
        if ( list == null ) {
            return null;
        }

        List<GamesModel> list1 = new ArrayList<GamesModel>( list.size() );
        for ( GamesDto gamesDto : list ) {
            list1.add( gamesDtoToGamesModel( gamesDto ) );
        }

        return list1;
    }

    protected GenresModel genresDtoToGenresModel(GenresDto genresDto) {
        if ( genresDto == null ) {
            return null;
        }

        GenresModel genresModel = new GenresModel();

        genresModel.setGenresId( genresDto.getGenresId() );
        genresModel.setGenreName( genresDto.getGenreName() );
        genresModel.setGames( gamesDtoListToGamesModelList( genresDto.getGames() ) );

        return genresModel;
    }

    protected List<GenresModel> genresDtoListToGenresModelList(List<GenresDto> list) {
        if ( list == null ) {
            return null;
        }

        List<GenresModel> list1 = new ArrayList<GenresModel>( list.size() );
        for ( GenresDto genresDto : list ) {
            list1.add( genresDtoToGenresModel( genresDto ) );
        }

        return list1;
    }
}
