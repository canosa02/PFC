package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.dto.GenresDto;
import com.jorgea.PFC.dto.SeriesDto;
import com.jorgea.PFC.model.FilmsModel;
import com.jorgea.PFC.model.GenresModel;
import com.jorgea.PFC.model.SeriesModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-14T11:58:36+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
public class FilmsModelMapperImpl implements FilmsModelMapper {

    @Override
    public FilmsDto toFilmsDto(FilmsModel filmsModel) {
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

    @Override
    public FilmsModel toFilmsModel(FilmsDto filmsDto) {
        if ( filmsDto == null ) {
            return null;
        }

        Integer filmId = null;
        String title = null;
        String description = null;
        String director = null;
        String releaseDate = null;
        double rating = 0.0d;
        List<GenresModel> genres = null;

        filmId = filmsDto.getFilmId();
        title = filmsDto.getTitle();
        description = filmsDto.getDescription();
        director = filmsDto.getDirector();
        releaseDate = filmsDto.getReleaseDate();
        rating = filmsDto.getRating();
        genres = genresDtoListToGenresModelList( filmsDto.getGenres() );

        FilmsModel filmsModel = new FilmsModel( filmId, title, description, director, releaseDate, rating, genres );

        return filmsModel;
    }

    protected List<FilmsDto> filmsModelListToFilmsDtoList(List<FilmsModel> list) {
        if ( list == null ) {
            return null;
        }

        List<FilmsDto> list1 = new ArrayList<FilmsDto>( list.size() );
        for ( FilmsModel filmsModel : list ) {
            list1.add( toFilmsDto( filmsModel ) );
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

    protected List<FilmsModel> filmsDtoListToFilmsModelList(List<FilmsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<FilmsModel> list1 = new ArrayList<FilmsModel>( list.size() );
        for ( FilmsDto filmsDto : list ) {
            list1.add( toFilmsModel( filmsDto ) );
        }

        return list1;
    }

    protected SeriesModel seriesDtoToSeriesModel(SeriesDto seriesDto) {
        if ( seriesDto == null ) {
            return null;
        }

        int filmId = 0;
        String title = null;
        String description = null;
        String director = null;
        String releaseDate = null;
        double rating = 0.0d;
        List<GenresModel> genres = null;

        filmId = seriesDto.getFilmId();
        title = seriesDto.getTitle();
        description = seriesDto.getDescription();
        director = seriesDto.getDirector();
        releaseDate = seriesDto.getReleaseDate();
        rating = seriesDto.getRating();
        List<GenresModel> list = seriesDto.getGenres();
        if ( list != null ) {
            genres = new ArrayList<GenresModel>( list );
        }

        SeriesModel seriesModel = new SeriesModel( filmId, title, description, director, releaseDate, rating, genres );

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

        int genresId = 0;
        String genreName = null;
        List<FilmsModel> films = null;
        List<SeriesModel> series = null;

        genresId = genresDto.getGenresId();
        genreName = genresDto.getGenreName();
        films = filmsDtoListToFilmsModelList( genresDto.getFilms() );
        series = seriesDtoListToSeriesModelList( genresDto.getSeries() );

        GenresModel genresModel = new GenresModel( genresId, genreName, films, series );

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
