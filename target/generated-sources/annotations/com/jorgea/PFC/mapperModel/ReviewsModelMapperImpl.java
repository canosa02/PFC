package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.ReviewsModel;
import com.jorgea.PFC.model.UsersModel;
import com.jorgea.PFC.to.CreateReviewsTo;
import com.jorgea.PFC.to.ReviewsTo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-06T14:26:13+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class ReviewsModelMapperImpl implements ReviewsModelMapper {

    @Override
    public ReviewsModel toReviewsModel(CreateReviewsTo createReviewsTo) {
        if ( createReviewsTo == null ) {
            return null;
        }

        ReviewsModel reviewsModel = new ReviewsModel();

        reviewsModel.setReviewText( createReviewsTo.getReviewText() );
        reviewsModel.setRating( createReviewsTo.getRating() );

        return reviewsModel;
    }

    @Override
    public ReviewsTo toReviewsTo(ReviewsModel reviewsModel) {
        if ( reviewsModel == null ) {
            return null;
        }

        ReviewsTo reviewsTo = new ReviewsTo();

        reviewsTo.setUserName( reviewsModelUserUsername( reviewsModel ) );
        reviewsTo.setReviewId( reviewsModel.getReviewId() );
        reviewsTo.setReviewText( reviewsModel.getReviewText() );
        reviewsTo.setRating( reviewsModel.getRating() );
        reviewsTo.setReviewDate( reviewsModel.getReviewDate() );

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
