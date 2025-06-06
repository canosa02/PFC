package com.jorgea.PFC.service;

import com.jorgea.PFC.to.CreateReviewsTo;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.PageResponseTo;
import com.jorgea.PFC.to.ReviewsTo;
import com.jorgea.PFC.to.UpdateReviewsTo;
import org.springframework.data.domain.Pageable;

public interface ReviewsService {

    PageResponseTo<GamesWithReviewsTo> findAllReviewsWithFilters(String title, String genreName, Pageable pageable);

    GamesWithReviewsTo findAllReviewsInOneGame(Integer gameId);

    ReviewsTo saveReviews(Integer gameId, CreateReviewsTo createReviewsTo);

    ReviewsTo updateReview(Integer reviewId, UpdateReviewsTo updateReviewsTo);

    ReviewsTo patchReview(Integer reviewId, UpdateReviewsTo updateReviewsTo);

    void deleteReview(Integer reviewId);
}
