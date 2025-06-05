package com.jorgea.PFC.controller;

import com.jorgea.PFC.dto.GamesWithReviewsDto;
import com.jorgea.PFC.dto.PageResponseDto;
import com.jorgea.PFC.mapperDto.GamesDtoMapper;
import com.jorgea.PFC.mapperDto.ReviewsDtoMapper;
import com.jorgea.PFC.service.ReviewsService;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{gameId}")
    public ResponseEntity<GamesWithReviewsDto> findAllReviewsInOneGame(@PathVariable Integer gameId){
        GamesWithReviewsTo gamesWithReviewsTo = reviewsService.findAllReviewsInOneGame(gameId);

        return ResponseEntity.ok(gamesDtoMapper.toGamesWithReviewsDto(gamesWithReviewsTo));
    }


}
