package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.dto.FilmsGenresDto;
import com.jorgea.PFC.dto.GenresDto;
import com.jorgea.PFC.dto.GenresNameDto;
import com.jorgea.PFC.to.FilmsGenresTo;
import com.jorgea.PFC.to.FilmsTo;
import com.jorgea.PFC.to.GenresNameTo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-15T17:10:06+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class FilmsDtoMapperImpl implements FilmsDtoMapper {

    @Override
    public FilmsDto toFilmsDto(FilmsTo filmsTo) {
        if ( filmsTo == null ) {
            return null;
        }

        FilmsDto filmsDto = new FilmsDto();

        filmsDto.setFilmId( filmsTo.getFilmId() );
        filmsDto.setTitle( filmsTo.getTitle() );
        filmsDto.setDescription( filmsTo.getDescription() );
        filmsDto.setDirector( filmsTo.getDirector() );
        filmsDto.setReleaseDate( filmsTo.getReleaseDate() );
        filmsDto.setRating( filmsTo.getRating() );
        List<GenresDto> list = filmsTo.getGenres();
        if ( list != null ) {
            filmsDto.setGenres( new ArrayList<GenresDto>( list ) );
        }

        return filmsDto;
    }

    @Override
    public FilmsTo toFilmsTo(FilmsDto filmsDto) {
        if ( filmsDto == null ) {
            return null;
        }

        FilmsTo filmsTo = new FilmsTo();

        filmsTo.setFilmId( filmsDto.getFilmId() );
        filmsTo.setTitle( filmsDto.getTitle() );
        filmsTo.setDescription( filmsDto.getDescription() );
        filmsTo.setDirector( filmsDto.getDirector() );
        filmsTo.setReleaseDate( filmsDto.getReleaseDate() );
        filmsTo.setRating( filmsDto.getRating() );
        List<GenresDto> list = filmsDto.getGenres();
        if ( list != null ) {
            filmsTo.setGenres( new ArrayList<GenresDto>( list ) );
        }

        return filmsTo;
    }

    @Override
    public FilmsGenresDto toFilmsGenresDto(FilmsGenresTo filmsGenresTo) {
        if ( filmsGenresTo == null ) {
            return null;
        }

        FilmsGenresDto filmsGenresDto = new FilmsGenresDto();

        filmsGenresDto.setFilmId( filmsGenresTo.getFilmId() );
        filmsGenresDto.setTitle( filmsGenresTo.getTitle() );
        filmsGenresDto.setDescription( filmsGenresTo.getDescription() );
        filmsGenresDto.setDirector( filmsGenresTo.getDirector() );
        filmsGenresDto.setReleaseDate( filmsGenresTo.getReleaseDate() );
        filmsGenresDto.setRating( filmsGenresTo.getRating() );
        filmsGenresDto.setGenres( genresNameToListToGenresNameDtoList( filmsGenresTo.getGenres() ) );

        return filmsGenresDto;
    }

    @Override
    public FilmsGenresTo toFilmsGenresTo(FilmsGenresDto filmsGenresDto) {
        if ( filmsGenresDto == null ) {
            return null;
        }

        FilmsGenresTo filmsGenresTo = new FilmsGenresTo();

        filmsGenresTo.setFilmId( filmsGenresDto.getFilmId() );
        filmsGenresTo.setTitle( filmsGenresDto.getTitle() );
        filmsGenresTo.setDescription( filmsGenresDto.getDescription() );
        filmsGenresTo.setDirector( filmsGenresDto.getDirector() );
        filmsGenresTo.setReleaseDate( filmsGenresDto.getReleaseDate() );
        filmsGenresTo.setRating( filmsGenresDto.getRating() );
        filmsGenresTo.setGenres( genresNameDtoListToGenresNameToList( filmsGenresDto.getGenres() ) );

        return filmsGenresTo;
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

    protected GenresNameTo genresNameDtoToGenresNameTo(GenresNameDto genresNameDto) {
        if ( genresNameDto == null ) {
            return null;
        }

        GenresNameTo genresNameTo = new GenresNameTo();

        genresNameTo.setName( genresNameDto.getName() );

        return genresNameTo;
    }

    protected List<GenresNameTo> genresNameDtoListToGenresNameToList(List<GenresNameDto> list) {
        if ( list == null ) {
            return null;
        }

        List<GenresNameTo> list1 = new ArrayList<GenresNameTo>( list.size() );
        for ( GenresNameDto genresNameDto : list ) {
            list1.add( genresNameDtoToGenresNameTo( genresNameDto ) );
        }

        return list1;
    }
}
