package com.jorgea.PFC.controller;

import com.jorgea.PFC.dto.CreateReviewsDto;
import com.jorgea.PFC.dto.GamesWithReviewsDto;
import com.jorgea.PFC.dto.PageResponseDto;
import com.jorgea.PFC.dto.ReviewsDto;
import com.jorgea.PFC.dto.UpdateReviewsDto;
import com.jorgea.PFC.mapperDto.GamesDtoMapper;
import com.jorgea.PFC.mapperDto.ReviewsDtoMapper;
import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.service.ReviewsService;
import com.jorgea.PFC.to.CreateReviewsTo;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.PageResponseTo;
import com.jorgea.PFC.to.ReviewsTo;
import com.jorgea.PFC.to.UpdateReviewsTo;

import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    private final ReviewsService reviewsService;

    private final ReviewsDtoMapper reviewsDtoMapper;

    private final GamesDtoMapper gamesDtoMapper;

    public ReviewsController(ReviewsService reviewsService, ReviewsDtoMapper reviewsDtoMapper, GamesDtoMapper gamesDtoMapper) {
        this.reviewsService = reviewsService;
        this.reviewsDtoMapper = reviewsDtoMapper;
        this.gamesDtoMapper = gamesDtoMapper;
    }

    @GetMapping("")
    public ResponseEntity<PageResponseDto<GamesWithReviewsDto>> findAllReviewsWithFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genreName,
            @PageableDefault(sort = "gameId", direction = Sort.Direction.ASC) Pageable pageable){

        PageResponseTo<GamesWithReviewsTo> gamesWithReviewsToPageResponseTo = reviewsService.findAllReviewsWithFilters(title, genreName, pageable);

        List<GamesWithReviewsDto> gamesWithReviewsDtos = gamesWithReviewsToPageResponseTo.getContent().stream()
                .map(reviewsDtoMapper::toGamesWithReviewsDto)
                .toList();

        PageResponseDto<GamesWithReviewsDto> response = new PageResponseDto<>(
                gamesWithReviewsDtos,
                (int) gamesWithReviewsToPageResponseTo.getCurrentPage(),
                gamesWithReviewsToPageResponseTo.getTotalPages()
        );

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewsDto> updateReview(@PathVariable Integer reviewId, @Valid @RequestBody UpdateReviewsDto updateReviewsDto) {
        UpdateReviewsTo updateReviewsTo = reviewsDtoMapper.toUpdateReviewsTo(updateReviewsDto);
        ReviewsTo reviewsTo = reviewsService.updateReview(reviewId, updateReviewsTo);
        ReviewsDto reviewsDto = reviewsDtoMapper.toReviewsDto(reviewsTo);
        return ResponseEntity.ok(reviewsDto);
    }

    @PatchMapping("/{reviewId}")
    public ResponseEntity<ReviewsDto> patchReview(@PathVariable Integer reviewId, @Valid @RequestBody UpdateReviewsDto updateReviewsDto) {
        UpdateReviewsTo updateReviewsTo = reviewsDtoMapper.toUpdateReviewsTo(updateReviewsDto);
        ReviewsTo reviewsTo = reviewsService.patchReview(reviewId, updateReviewsTo);
        ReviewsDto reviewsDto = reviewsDtoMapper.toReviewsDto(reviewsTo);
        return ResponseEntity.ok(reviewsDto);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer reviewId) {
        reviewsService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
