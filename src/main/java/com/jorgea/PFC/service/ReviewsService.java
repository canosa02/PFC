package com.jorgea.PFC.service;

import com.jorgea.PFC.to.CreateReviewsTo;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.PageResponseTo;
import com.jorgea.PFC.to.ReviewsTo;
import org.springframework.data.domain.Pageable;

public interface ReviewsService {

    PageResponseTo<GamesWithReviewsTo> findAllReviewsWithFilters(String title, String genreName, Pageable pageable);

    GamesWithReviewsTo findAllReviewsInOneGame(Integer gameId);

    ReviewsTo saveReviews(Integer gameId, CreateReviewsTo createReviewsTo);
}
