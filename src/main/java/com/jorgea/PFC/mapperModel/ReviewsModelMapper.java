package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.ReviewsModel;
import com.jorgea.PFC.to.ReviewsTo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewsModelMapper {

    @Mapping(source = "user.username", target = "userName")
    ReviewsTo toReviewsTo(ReviewsModel reviewsModel);
}
