package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.CreateReviewsDto;
import com.jorgea.PFC.dto.GamesWithReviewsDto;
import com.jorgea.PFC.dto.GenresNameDto;
import com.jorgea.PFC.dto.ReviewsDto;
import com.jorgea.PFC.dto.UpdateReviewsDto;
import com.jorgea.PFC.to.CreateReviewsTo;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.ReviewsTo;
import com.jorgea.PFC.to.UpdateReviewsTo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-06T09:50:59+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ReviewsDtoMapperImpl implements ReviewsDtoMapper {

    @Override
    public ReviewsDto toReviewsDto(ReviewsTo reviewsTo) {
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

    @Override
    public CreateReviewsTo toCreateReviewsTo(CreateReviewsDto createReviewsDto) {
        if ( createReviewsDto == null ) {
            return null;
        }

        CreateReviewsTo createReviewsTo = new CreateReviewsTo();

        createReviewsTo.setUserId( createReviewsDto.getUserId() );
        createReviewsTo.setReviewText( createReviewsDto.getReviewText() );
        createReviewsTo.setRating( createReviewsDto.getRating() );

        return createReviewsTo;
    }

    @Override
    public UpdateReviewsTo toUpdateReviewsTo(UpdateReviewsDto updateReviewsDto) {
        if ( updateReviewsDto == null ) {
            return null;
        }

        UpdateReviewsTo updateReviewsTo = new UpdateReviewsTo();

        updateReviewsTo.setReviewText( updateReviewsDto.getReviewText() );
        updateReviewsTo.setRating( updateReviewsDto.getRating() );

        return updateReviewsTo;
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

    protected List<ReviewsDto> reviewsToListToReviewsDtoList(List<ReviewsTo> list) {
        if ( list == null ) {
            return null;
        }

        List<ReviewsDto> list1 = new ArrayList<ReviewsDto>( list.size() );
        for ( ReviewsTo reviewsTo : list ) {
            list1.add( toReviewsDto( reviewsTo ) );
        }

        return list1;
    }
}
