package com.jorgea.PFC.service;

import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Pageable;

public interface ReviewsService {

    PageResponseTo<GamesWithReviewsTo> findAllReviewsWithFilters(String title, String genreName, Pageable pageable);

}
