package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.dto.GenresDto;
import com.jorgea.PFC.dto.SeriesDto;
import com.jorgea.PFC.to.GenresTo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-15T17:10:05+0200",
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
        List<FilmsDto> list = genresDto.getFilms();
        if ( list != null ) {
            genresTo.setFilms( new ArrayList<FilmsDto>( list ) );
        }
        List<SeriesDto> list1 = genresDto.getSeries();
        if ( list1 != null ) {
            genresTo.setSeries( new ArrayList<SeriesDto>( list1 ) );
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
        List<FilmsDto> list = genresTo.getFilms();
        if ( list != null ) {
            genresDto.setFilms( new ArrayList<FilmsDto>( list ) );
        }
        List<SeriesDto> list1 = genresTo.getSeries();
        if ( list1 != null ) {
            genresDto.setSeries( new ArrayList<SeriesDto>( list1 ) );
        }

        return genresDto;
    }
}
