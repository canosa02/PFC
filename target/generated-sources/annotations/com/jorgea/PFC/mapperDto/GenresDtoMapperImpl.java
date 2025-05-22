package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.GamesDto;
import com.jorgea.PFC.dto.GenresDto;
import com.jorgea.PFC.dto.GenresWithoutGamesDto;
import com.jorgea.PFC.to.GenresTo;
import com.jorgea.PFC.to.GenresWithoutGamesTo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-22T12:48:25+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class GenresDtoMapperImpl implements GenresDtoMapper {

    @Override
    public GenresTo toGenresTo(GenresDto genresDto) {
        if ( genresDto == null ) {
            return null;
        }

        GenresTo genresTo = new GenresTo();

        genresTo.setGenresId( genresDto.getGenresId() );
        genresTo.setGenreName( genresDto.getGenreName() );
        List<GamesDto> list = genresDto.getGames();
        if ( list != null ) {
            genresTo.setGames( new ArrayList<GamesDto>( list ) );
        }

        return genresTo;
    }

    @Override
    public GenresDto toGenresDto(GenresTo genresTo) {
        if ( genresTo == null ) {
            return null;
        }

        GenresDto genresDto = new GenresDto();

        genresDto.setGenresId( genresTo.getGenresId() );
        genresDto.setGenreName( genresTo.getGenreName() );
        List<GamesDto> list = genresTo.getGames();
        if ( list != null ) {
            genresDto.setGames( new ArrayList<GamesDto>( list ) );
        }

        return genresDto;
    }

    @Override
    public GenresWithoutGamesDto toGenresWithoutGamesDto(GenresWithoutGamesTo genresWithoutGamesTo) {
        if ( genresWithoutGamesTo == null ) {
            return null;
        }

        GenresWithoutGamesDto genresWithoutGamesDto = new GenresWithoutGamesDto();

        genresWithoutGamesDto.setGenresId( genresWithoutGamesTo.getGenresId() );
        genresWithoutGamesDto.setGenreName( genresWithoutGamesTo.getGenreName() );

        return genresWithoutGamesDto;
    }
}
