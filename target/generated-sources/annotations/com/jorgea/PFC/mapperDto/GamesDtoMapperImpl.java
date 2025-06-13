package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.GamesGenresDto;
import com.jorgea.PFC.dto.GamesPatchDto;
import com.jorgea.PFC.dto.GamesPostDto;
import com.jorgea.PFC.dto.GamesPutDto;
import com.jorgea.PFC.dto.GamesWithReviewsDto;
import com.jorgea.PFC.dto.GamesWithoutGenresDto;
import com.jorgea.PFC.dto.GenresNameDto;
import com.jorgea.PFC.dto.ReviewsDto;
import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.GamesPatchTo;
import com.jorgea.PFC.to.GamesPostTo;
import com.jorgea.PFC.to.GamesPutTo;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.GamesWithoutGenresTo;
import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.ReviewsTo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-13T08:58:20+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class GamesDtoMapperImpl implements GamesDtoMapper {

    @Override
    public GamesGenresDto toGamesGenresDto(GamesGenresTo gamesGenresTo) {
        if ( gamesGenresTo == null ) {
            return null;
        }

        GamesGenresDto gamesGenresDto = new GamesGenresDto();

        gamesGenresDto.setDescription( gamesGenresTo.getDescription() );
        gamesGenresDto.setDeveloper( gamesGenresTo.getDeveloper() );
        gamesGenresDto.setGameId( gamesGenresTo.getGameId() );
        gamesGenresDto.setGenres( genresNameToListToGenresNameDtoList( gamesGenresTo.getGenres() ) );
        gamesGenresDto.setRating( gamesGenresTo.getRating() );
        gamesGenresDto.setReleaseDate( gamesGenresTo.getReleaseDate() );
        gamesGenresDto.setTitle( gamesGenresTo.getTitle() );

        return gamesGenresDto;
    }

    @Override
    public GamesPostTo toGamesPostTo(GamesPostDto gamesPostDto) {
        if ( gamesPostDto == null ) {
            return null;
        }

        GamesPostTo gamesPostTo = new GamesPostTo();

        gamesPostTo.setDescription( gamesPostDto.getDescription() );
        gamesPostTo.setDeveloper( gamesPostDto.getDeveloper() );
        gamesPostTo.setRating( gamesPostDto.getRating() );
        gamesPostTo.setReleaseDate( gamesPostDto.getReleaseDate() );
        gamesPostTo.setTitle( gamesPostDto.getTitle() );

        return gamesPostTo;
    }

    @Override
    public GamesWithoutGenresDto toGamesWithoutGenresDto(GamesWithoutGenresTo gamesWithoutGenresTo) {
        if ( gamesWithoutGenresTo == null ) {
            return null;
        }

        GamesWithoutGenresDto gamesWithoutGenresDto = new GamesWithoutGenresDto();

        gamesWithoutGenresDto.setDescription( gamesWithoutGenresTo.getDescription() );
        gamesWithoutGenresDto.setDeveloper( gamesWithoutGenresTo.getDeveloper() );
        gamesWithoutGenresDto.setGameId( gamesWithoutGenresTo.getGameId() );
        gamesWithoutGenresDto.setRating( gamesWithoutGenresTo.getRating() );
        gamesWithoutGenresDto.setReleaseDate( gamesWithoutGenresTo.getReleaseDate() );
        gamesWithoutGenresDto.setTitle( gamesWithoutGenresTo.getTitle() );

        return gamesWithoutGenresDto;
    }

    @Override
    public GamesPutTo toGamesPutTo(GamesPutDto gamesPutDto) {
        if ( gamesPutDto == null ) {
            return null;
        }

        GamesPutTo gamesPutTo = new GamesPutTo();

        gamesPutTo.setDescription( gamesPutDto.getDescription() );
        gamesPutTo.setDeveloper( gamesPutDto.getDeveloper() );
        gamesPutTo.setRating( gamesPutDto.getRating() );
        gamesPutTo.setReleaseDate( gamesPutDto.getReleaseDate() );
        gamesPutTo.setTitle( gamesPutDto.getTitle() );

        return gamesPutTo;
    }

    @Override
    public GamesPatchTo toGamesPatchTo(GamesPatchDto gamesPatchDto) {
        if ( gamesPatchDto == null ) {
            return null;
        }

        GamesPatchTo gamesPatchTo = new GamesPatchTo();

        gamesPatchTo.setDescription( gamesPatchDto.getDescription() );
        gamesPatchTo.setDeveloper( gamesPatchDto.getDeveloper() );
        gamesPatchTo.setRating( gamesPatchDto.getRating() );
        gamesPatchTo.setReleaseDate( gamesPatchDto.getReleaseDate() );
        gamesPatchTo.setTitle( gamesPatchDto.getTitle() );

        return gamesPatchTo;
    }

    @Override
    public GamesWithReviewsDto toGamesWithReviewsDto(GamesWithReviewsTo gamesWithReviewsTo) {
        if ( gamesWithReviewsTo == null ) {
            return null;
        }

        GamesWithReviewsDto gamesWithReviewsDto = new GamesWithReviewsDto();

        gamesWithReviewsDto.setTitle( gamesWithReviewsTo.getTitle() );
        gamesWithReviewsDto.setDescription( gamesWithReviewsTo.getDescription() );
        gamesWithReviewsDto.setDeveloper( gamesWithReviewsTo.getDeveloper() );
        gamesWithReviewsDto.setReleaseDate( gamesWithReviewsTo.getReleaseDate() );
        gamesWithReviewsDto.setRating( gamesWithReviewsTo.getRating() );
        gamesWithReviewsDto.setGenres( genresNameToListToGenresNameDtoList( gamesWithReviewsTo.getGenres() ) );
        gamesWithReviewsDto.setReviews( reviewsToListToReviewsDtoList( gamesWithReviewsTo.getReviews() ) );

        return gamesWithReviewsDto;
    }

    protected GenresNameDto genresNameToToGenresNameDto(GenresNameTo genresNameTo) {
        if ( genresNameTo == null ) {
            return null;
        }

        GenresNameDto genresNameDto = new GenresNameDto();

        genresNameDto.setGenreName( genresNameTo.getGenreName() );

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

    protected ReviewsDto reviewsToToReviewsDto(ReviewsTo reviewsTo) {
        if ( reviewsTo == null ) {
            return null;
        }

        ReviewsDto reviewsDto = new ReviewsDto();

        reviewsDto.setReviewId( reviewsTo.getReviewId() );
        reviewsDto.setUserName( reviewsTo.getUserName() );
        reviewsDto.setReviewText( reviewsTo.getReviewText() );
        reviewsDto.setRating( reviewsTo.getRating() );
        reviewsDto.setReviewDate( reviewsTo.getReviewDate() );

        return reviewsDto;
    }

    protected List<ReviewsDto> reviewsToListToReviewsDtoList(List<ReviewsTo> list) {
        if ( list == null ) {
            return null;
        }

        List<ReviewsDto> list1 = new ArrayList<ReviewsDto>( list.size() );
        for ( ReviewsTo reviewsTo : list ) {
            list1.add( reviewsToToReviewsDto( reviewsTo ) );
        }

        return list1;
    }
}
