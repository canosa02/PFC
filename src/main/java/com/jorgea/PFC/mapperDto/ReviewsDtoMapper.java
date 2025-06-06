package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.CreateReviewsDto;
import com.jorgea.PFC.dto.GamesWithReviewsDto;
import com.jorgea.PFC.dto.ReviewsDto;
import com.jorgea.PFC.dto.UpdateReviewsDto;
import com.jorgea.PFC.to.CreateReviewsTo;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.ReviewsTo;
import com.jorgea.PFC.to.UpdateReviewsTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewsDtoMapper {

    ReviewsDto toReviewsDto(ReviewsTo reviewsTo);

    GamesWithReviewsDto toGamesWithReviewsDto(GamesWithReviewsTo gamesWithReviewsTo);

    CreateReviewsTo toCreateReviewsTo(CreateReviewsDto createReviewsDto);

    UpdateReviewsTo toUpdateReviewsTo(UpdateReviewsDto updateReviewsDto);
}
