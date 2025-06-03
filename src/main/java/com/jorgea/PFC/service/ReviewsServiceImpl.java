package com.jorgea.PFC.service;

import com.jorgea.PFC.dto.ReviewsWithoutIdDto;
import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.model.GenresInGamesModel;
import com.jorgea.PFC.model.ReviewsModel;
import com.jorgea.PFC.repository.GamesRepository;
import com.jorgea.PFC.repository.ReviewsRepository;
import com.jorgea.PFC.specification.GamesSpecification;
import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.PageResponseTo;
import com.jorgea.PFC.to.ReviewsWithoutIdTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReviewsServiceImpl implements ReviewsService {

    private final ReviewsRepository reviewsRepository;

    private final GamesRepository gamesRepository;

    public ReviewsServiceImpl(ReviewsRepository reviewsRepository, GamesRepository gamesRepository) {
        this.reviewsRepository = reviewsRepository;
        this.gamesRepository = gamesRepository;
    }

    @Override
    public PageResponseTo<GamesWithReviewsTo> findAllReviewsWithFilters(String title, String genreName, Pageable pageable) {

        Specification<GamesModel> spec = Specification.where(null);

        if (title != null && !title.isBlank()) {
            spec = spec.and(GamesSpecification.hasTitle(title));
        }

        if (genreName != null && !genreName.isBlank()) {
            spec = spec.and(GamesSpecification.hasGenreName(genreName));
        }

        Page<GamesModel> gamesModelPage = gamesRepository.findAll(spec, pageable);

        List<GamesWithReviewsTo> gamesWithReviewsTos = new ArrayList<>();

        for (GamesModel gamesModel : gamesModelPage.getContent()) {
            List<ReviewsWithoutIdTo> reviewsWithoutIdTos = new ArrayList<>();
            List<GenresNameTo> genresNameTos = new ArrayList<>();

            if (gamesModel.getGenres() != null) {
                for (GenresInGamesModel genresInGamesModel : gamesModel.getGenres()) {
                    genresNameTos.add(new GenresNameTo(genresInGamesModel.getGenre().getGenreName()));
                }
            }

            if (gamesModel.getReviews() != null) {
                for (ReviewsModel reviewsModel : gamesModel.getReviews()) {
                    reviewsWithoutIdTos.add(new ReviewsWithoutIdTo(
                            reviewsModel.getReviewText(),
                            reviewsModel.getRating(),
                            reviewsModel.getReviewDate()));
                }
            }
            gamesWithReviewsTos.add(new GamesWithReviewsTo(
                    gamesModel.getTitle(),
                    gamesModel.getDescription(),
                    gamesModel.getDeveloper(),
                    gamesModel.getReleaseDate(),
                    gamesModel.getRating(),
                    genresNameTos,
                    reviewsWithoutIdTos
            ));
        }
        return new PageResponseTo<>(
                gamesWithReviewsTos,
                gamesModelPage.getPageable().getPageNumber() + 1,
                gamesModelPage.getTotalPages()
        );
    }
}
