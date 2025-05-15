package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.dto.GenresDto;
import com.jorgea.PFC.dto.SeriesDto;
import com.jorgea.PFC.model.FilmsModel;
import com.jorgea.PFC.model.GenresModel;
import com.jorgea.PFC.model.SeriesModel;
import com.jorgea.PFC.to.FilmsTo;
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
public class FilmsModelMapperImpl implements FilmsModelMapper {

    @Override
    public FilmsTo toFilmsTo(FilmsModel filmsModel) {
        if ( filmsModel == null ) {
            return null;
        }

        FilmsTo filmsTo = new FilmsTo();

        filmsTo.setFilmId( filmsModel.getFilmId() );
        filmsTo.setTitle( filmsModel.getTitle() );
        filmsTo.setDescription( filmsModel.getDescription() );
        filmsTo.setDirector( filmsModel.getDirector() );
        filmsTo.setReleaseDate( filmsModel.getReleaseDate() );
        filmsTo.setRating( filmsModel.getRating() );
        filmsTo.setGenres( genresModelListToGenresDtoList( filmsModel.getGenres() ) );

        return filmsTo;
    }

    @Override
    public FilmsModel toFilmsModel(FilmsTo filmsTo) {
        if ( filmsTo == null ) {
            return null;
        }

        FilmsModel filmsModel = new FilmsModel();

        filmsModel.setFilmId( filmsTo.getFilmId() );
        filmsModel.setTitle( filmsTo.getTitle() );
        filmsModel.setDescription( filmsTo.getDescription() );
        filmsModel.setDirector( filmsTo.getDirector() );
        filmsModel.setReleaseDate( filmsTo.getReleaseDate() );
        filmsModel.setRating( filmsTo.getRating() );
        filmsModel.setGenres( genresDtoListToGenresModelList( filmsTo.getGenres() ) );

        return filmsModel;
    }

    protected FilmsDto filmsModelToFilmsDto(FilmsModel filmsModel) {
        if ( filmsModel == null ) {
            return null;
        }

        FilmsDto filmsDto = new FilmsDto();

        filmsDto.setFilmId( filmsModel.getFilmId() );
        filmsDto.setTitle( filmsModel.getTitle() );
        filmsDto.setDescription( filmsModel.getDescription() );
        filmsDto.setDirector( filmsModel.getDirector() );
        filmsDto.setReleaseDate( filmsModel.getReleaseDate() );
        filmsDto.setRating( filmsModel.getRating() );
        filmsDto.setGenres( genresModelListToGenresDtoList( filmsModel.getGenres() ) );

        return filmsDto;
    }

    protected List<FilmsDto> filmsModelListToFilmsDtoList(List<FilmsModel> list) {
        if ( list == null ) {
            return null;
        }

        List<FilmsDto> list1 = new ArrayList<FilmsDto>( list.size() );
        for ( FilmsModel filmsModel : list ) {
            list1.add( filmsModelToFilmsDto( filmsModel ) );
        }

        return list1;
    }

    protected SeriesDto seriesModelToSeriesDto(SeriesModel seriesModel) {
        if ( seriesModel == null ) {
            return null;
        }

        SeriesDto seriesDto = new SeriesDto();

        seriesDto.setFilmId( seriesModel.getFilmId() );
        seriesDto.setTitle( seriesModel.getTitle() );
        seriesDto.setDescription( seriesModel.getDescription() );
        seriesDto.setDirector( seriesModel.getDirector() );
        seriesDto.setReleaseDate( seriesModel.getReleaseDate() );
        seriesDto.setRating( seriesModel.getRating() );
        List<GenresModel> list = seriesModel.getGenres();
        if ( list != null ) {
            seriesDto.setGenres( new ArrayList<GenresModel>( list ) );
        }

        return seriesDto;
    }

    protected List<SeriesDto> seriesModelListToSeriesDtoList(List<SeriesModel> list) {
        if ( list == null ) {
            return null;
        }

        List<SeriesDto> list1 = new ArrayList<SeriesDto>( list.size() );
        for ( SeriesModel seriesModel : list ) {
            list1.add( seriesModelToSeriesDto( seriesModel ) );
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
        genresDto.setFilms( filmsModelListToFilmsDtoList( genresModel.getFilms() ) );
        genresDto.setSeries( seriesModelListToSeriesDtoList( genresModel.getSeries() ) );

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

    protected FilmsModel filmsDtoToFilmsModel(FilmsDto filmsDto) {
        if ( filmsDto == null ) {
            return null;
        }

        FilmsModel filmsModel = new FilmsModel();

        filmsModel.setFilmId( filmsDto.getFilmId() );
        filmsModel.setTitle( filmsDto.getTitle() );
        filmsModel.setDescription( filmsDto.getDescription() );
        filmsModel.setDirector( filmsDto.getDirector() );
        filmsModel.setReleaseDate( filmsDto.getReleaseDate() );
        filmsModel.setRating( filmsDto.getRating() );
        filmsModel.setGenres( genresDtoListToGenresModelList( filmsDto.getGenres() ) );

        return filmsModel;
    }

    protected List<FilmsModel> filmsDtoListToFilmsModelList(List<FilmsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<FilmsModel> list1 = new ArrayList<FilmsModel>( list.size() );
        for ( FilmsDto filmsDto : list ) {
            list1.add( filmsDtoToFilmsModel( filmsDto ) );
        }

        return list1;
    }

    protected SeriesModel seriesDtoToSeriesModel(SeriesDto seriesDto) {
        if ( seriesDto == null ) {
            return null;
        }

        SeriesModel seriesModel = new SeriesModel();

        seriesModel.setFilmId( seriesDto.getFilmId() );
        seriesModel.setTitle( seriesDto.getTitle() );
        seriesModel.setDescription( seriesDto.getDescription() );
        seriesModel.setDirector( seriesDto.getDirector() );
        seriesModel.setReleaseDate( seriesDto.getReleaseDate() );
        seriesModel.setRating( seriesDto.getRating() );
        List<GenresModel> list = seriesDto.getGenres();
        if ( list != null ) {
            seriesModel.setGenres( new ArrayList<GenresModel>( list ) );
        }

        return seriesModel;
    }

    protected List<SeriesModel> seriesDtoListToSeriesModelList(List<SeriesDto> list) {
        if ( list == null ) {
            return null;
        }

        List<SeriesModel> list1 = new ArrayList<SeriesModel>( list.size() );
        for ( SeriesDto seriesDto : list ) {
            list1.add( seriesDtoToSeriesModel( seriesDto ) );
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
        genresModel.setFilms( filmsDtoListToFilmsModelList( genresDto.getFilms() ) );
        genresModel.setSeries( seriesDtoListToSeriesModelList( genresDto.getSeries() ) );

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
