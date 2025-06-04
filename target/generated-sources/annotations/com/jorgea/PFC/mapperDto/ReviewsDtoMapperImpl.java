package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.GamesWithReviewsDto;
import com.jorgea.PFC.dto.GenresNameDto;
import com.jorgea.PFC.dto.ReviewsDto;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.ReviewsTo;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-04T16:30:56+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class ReviewsDtoMapperImpl implements ReviewsDtoMapper {

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
        reviewsDto.setReviewText( reviewsTo.getReviewText() );
        reviewsDto.setRating( reviewsTo.getRating() );
        if ( reviewsTo.getReviewDate() != null ) {
            reviewsDto.setReviewDate( LocalDateTime.ofInstant( reviewsTo.getReviewDate().toInstant(), ZoneId.of( "UTC" ) ) );
        }

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
