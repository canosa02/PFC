package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.ReviewsModel;
import com.jorgea.PFC.model.UsersModel;
import com.jorgea.PFC.to.ReviewsTo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-13T10:47:21+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ReviewsModelMapperImpl implements ReviewsModelMapper {

    @Override
    public ReviewsTo toReviewsTo(ReviewsModel reviewsModel) {
        if ( reviewsModel == null ) {
            return null;
        }

        ReviewsTo reviewsTo = new ReviewsTo();

        reviewsTo.setUserName( reviewsModelUserUsername( reviewsModel ) );
        reviewsTo.setRating( reviewsModel.getRating() );
        reviewsTo.setReviewDate( reviewsModel.getReviewDate() );
        reviewsTo.setReviewId( reviewsModel.getReviewId() );
        reviewsTo.setReviewText( reviewsModel.getReviewText() );

        return reviewsTo;
    }

    private String reviewsModelUserUsername(ReviewsModel reviewsModel) {
        UsersModel user = reviewsModel.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getUsername();
    }
}
