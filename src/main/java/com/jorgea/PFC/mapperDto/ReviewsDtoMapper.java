package com.jorgea.PFC.mapperDto;

import com.jorgea.PFC.dto.GamesWithReviewsDto;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewsDtoMapper {

    GamesWithReviewsDto toGamesWithReviewsDto(GamesWithReviewsTo gamesWithReviewsTo);

}
