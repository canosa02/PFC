package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.GamesWithReviewsDto;
import com.jorgea.PFC.dto.GenresDto;
import com.jorgea.PFC.dto.ReviewsDto;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.ReviewsWithoutIdTo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-03T16:47:09+0200",
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
        gamesWithReviewsDto.setGenres( genresNameToListToGenresDtoList( gamesWithReviewsTo.getGenres() ) );
        gamesWithReviewsDto.setReviews( reviewsWithoutIdToListToReviewsDtoList( gamesWithReviewsTo.getReviews() ) );

        return gamesWithReviewsDto;
    }

    protected GenresDto genresNameToToGenresDto(GenresNameTo genresNameTo) {
        if ( genresNameTo == null ) {
            return null;
        }

        GenresDto genresDto = new GenresDto();

        genresDto.setGenreName( genresNameTo.getGenreName() );

        return genresDto;
    }

    protected List<GenresDto> genresNameToListToGenresDtoList(List<GenresNameTo> list) {
        if ( list == null ) {
            return null;
        }

        List<GenresDto> list1 = new ArrayList<GenresDto>( list.size() );
        for ( GenresNameTo genresNameTo : list ) {
            list1.add( genresNameToToGenresDto( genresNameTo ) );
        }

        return list1;
    }

    protected ReviewsDto reviewsWithoutIdToToReviewsDto(ReviewsWithoutIdTo reviewsWithoutIdTo) {
        if ( reviewsWithoutIdTo == null ) {
            return null;
        }

        ReviewsDto reviewsDto = new ReviewsDto();

        reviewsDto.setReviewText( reviewsWithoutIdTo.getReviewText() );
        reviewsDto.setRating( reviewsWithoutIdTo.getRating() );
        reviewsDto.setReviewDate( reviewsWithoutIdTo.getReviewDate() );

        return reviewsDto;
    }

    protected List<ReviewsDto> reviewsWithoutIdToListToReviewsDtoList(List<ReviewsWithoutIdTo> list) {
        if ( list == null ) {
            return null;
        }

        List<ReviewsDto> list1 = new ArrayList<ReviewsDto>( list.size() );
        for ( ReviewsWithoutIdTo reviewsWithoutIdTo : list ) {
            list1.add( reviewsWithoutIdToToReviewsDto( reviewsWithoutIdTo ) );
        }

        return list1;
    }
}
