package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.ReviewsModel;
import com.jorgea.PFC.to.CreateReviewsTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewsModelMapper {
    ReviewsModel toReviewsModel(CreateReviewsTo createReviewsTo);
}
