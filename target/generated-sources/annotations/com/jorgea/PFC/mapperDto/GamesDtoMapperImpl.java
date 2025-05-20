package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.GamesDto;
import com.jorgea.PFC.dto.GamesGenresDto;
import com.jorgea.PFC.dto.GamesWithoutGenresDto;
import com.jorgea.PFC.dto.GenresDto;
import com.jorgea.PFC.dto.GenresNameDto;
import com.jorgea.PFC.dto.GamesPostDto;
import com.jorgea.PFC.to.*;
import com.jorgea.PFC.to.GamesPostTo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T08:45:32+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class GamesDtoMapperImpl implements GamesDtoMapper {

    @Override
    public GamesDto toGamesDto(GamesTo gamesTo) {
        if ( gamesTo == null ) {
            return null;
        }

        GamesDto gamesDto = new GamesDto();

        gamesDto.setGameId( gamesTo.getGameId() );
        gamesDto.setTitle( gamesTo.getTitle() );
        gamesDto.setDescription( gamesTo.getDescription() );
        gamesDto.setDeveloper( gamesTo.getDeveloper() );
        gamesDto.setReleaseDate( gamesTo.getReleaseDate() );
        gamesDto.setRating( gamesTo.getRating() );
        List<GenresDto> list = gamesTo.getGenres();
        if ( list != null ) {
            gamesDto.setGenres( new ArrayList<GenresDto>( list ) );
        }

        return gamesDto;
    }

    @Override
    public GamesTo toGamesTo(GamesDto gamesDto) {
        if ( gamesDto == null ) {
            return null;
        }

        GamesTo gamesTo = new GamesTo();

        gamesTo.setGameId( gamesDto.getGameId() );
        gamesTo.setTitle( gamesDto.getTitle() );
        gamesTo.setDescription( gamesDto.getDescription() );
        gamesTo.setDeveloper( gamesDto.getDeveloper() );
        gamesTo.setReleaseDate( gamesDto.getReleaseDate() );
        gamesTo.setRating( gamesDto.getRating() );
        List<GenresDto> list = gamesDto.getGenres();
        if ( list != null ) {
            gamesTo.setGenres( new ArrayList<GenresDto>( list ) );
        }

        return gamesTo;
    }

    @Override
    public GamesGenresDto toGamesGenresDto(GamesGenresTo gamesGenresTo) {
        if ( gamesGenresTo == null ) {
            return null;
        }

        GamesGenresDto gamesGenresDto = new GamesGenresDto();

        gamesGenresDto.setGameId( gamesGenresTo.getGameId() );
        gamesGenresDto.setTitle( gamesGenresTo.getTitle() );
        gamesGenresDto.setDescription( gamesGenresTo.getDescription() );
        gamesGenresDto.setDeveloper( gamesGenresTo.getDeveloper() );
        gamesGenresDto.setReleaseDate( gamesGenresTo.getReleaseDate() );
        gamesGenresDto.setRating( gamesGenresTo.getRating() );
        gamesGenresDto.setGenres( genresNameToListToGenresNameDtoList( gamesGenresTo.getGenres() ) );

        return gamesGenresDto;
    }

    @Override
    public GamesPostTo toSaveGamesTo(GamesPostDto gamesPostDto) {
        if ( gamesPostDto == null ) {
            return null;
        }

        GamesPostTo gamesPostTo = new GamesPostTo();

        gamesPostTo.setTitle( gamesPostDto.getTitle() );
        gamesPostTo.setDescription( gamesPostDto.getDescription() );
        gamesPostTo.setDeveloper( gamesPostDto.getDeveloper() );
        gamesPostTo.setReleaseDate( gamesPostDto.getReleaseDate() );
        gamesPostTo.setRating( gamesPostDto.getRating() );

        return gamesPostTo;
    }

    @Override
    public GamesWithoutGenresDto toGamesWithoutGenresDto(GamesWithoutGenresTo gamesWithoutGenresTo) {
        if ( gamesWithoutGenresTo == null ) {
            return null;
        }

        GamesWithoutGenresDto gamesWithoutGenresDto = new GamesWithoutGenresDto();

        gamesWithoutGenresDto.setGameId( gamesWithoutGenresTo.getGameId() );
        gamesWithoutGenresDto.setTitle( gamesWithoutGenresTo.getTitle() );
        gamesWithoutGenresDto.setDescription( gamesWithoutGenresTo.getDescription() );
        gamesWithoutGenresDto.setDeveloper( gamesWithoutGenresTo.getDeveloper() );
        gamesWithoutGenresDto.setReleaseDate( gamesWithoutGenresTo.getReleaseDate() );
        gamesWithoutGenresDto.setRating( gamesWithoutGenresTo.getRating() );

        return gamesWithoutGenresDto;
    }

    protected GenresNameDto genresNameToToGenresNameDto(GenresNameTo genresNameTo) {
        if ( genresNameTo == null ) {
            return null;
        }

        GenresNameDto genresNameDto = new GenresNameDto();

        genresNameDto.setName( genresNameTo.getName() );

        return genresNameDto;
    }

    protected List<GenresNameDto> genresNameToListToGenresNameDtoList(List<GenresNameTo> list) {
        if ( list == null ) {
            return null;
        }

        List<GenresNameDto> list1 = new ArrayList<GenresNameDto>( list.size() );
        for ( GenresNameTo genresNameTo : list ) {
            list1.add( genresNameToToGenresNameDto( genresNameTo ) );
        }

        return list1;
    }
}
