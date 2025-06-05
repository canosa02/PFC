package com.jorgea.PFC.service;

import com.jorgea.PFC.dto.ReviewsWithoutIdDto;
import com.jorgea.PFC.exception.InstanceNotFoundException;
import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.model.GenresInGamesModel;
import com.jorgea.PFC.model.ReviewsModel;
import com.jorgea.PFC.repository.GamesRepository;
import com.jorgea.PFC.repository.ReviewsRepository;
import com.jorgea.PFC.specification.GamesSpecification;
import com.jorgea.PFC.to.CreateReviewsTo;
import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.GamesWithReviewsTo;
import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.PageResponseTo;
import com.jorgea.PFC.to.ReviewsTo;
import com.jorgea.PFC.to.ReviewsWithoutIdTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            List<ReviewsTo> reviewsTos = new ArrayList<>();
            List<GenresNameTo> genresNameTos = new ArrayList<>();

            if (gamesModel.getGenres() != null) {
                for (GenresInGamesModel genresInGamesModel : gamesModel.getGenres()) {
                    genresNameTos.add(new GenresNameTo(genresInGamesModel.getGenre().getGenreName()));
                }
            }

            if (gamesModel.getReviews() != null) {
                for (ReviewsModel reviewsModel : gamesModel.getReviews()) {
                    reviewsTos.add(new ReviewsTo(
                            reviewsModel.getReviewId(),
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
                    reviewsTos
            ));
        }
        return new PageResponseTo<>(
                gamesWithReviewsTos,
                gamesModelPage.getPageable().getPageNumber() + 1,
                gamesModelPage.getTotalPages()
        );
    }

    @Override
    public GamesWithReviewsTo findAllReviewsInOneGame(Integer gameId){
        GamesModel gamesModel = gamesRepository.findById(gameId).orElseThrow(InstanceNotFoundException::new);

        GamesWithReviewsTo gamesWithReviewsTo = new GamesWithReviewsTo();

        List<ReviewsTo> reviewsTos = new ArrayList<>();
        List<GenresNameTo> genresNameTos = new ArrayList<>();

        if (gamesModel.getGenres() != null){
            for(GenresInGamesModel genresInGamesModel : gamesModel.getGenres()){
                genresNameTos.add(new GenresNameTo(genresInGamesModel.getGenre().getGenreName()));
            }
        }

        if (gamesModel.getReviews() != null){
            for(ReviewsModel reviewsModel : gamesModel.getReviews()){
                reviewsTos.add(new ReviewsTo(
                        reviewsModel.getReviewId(),
                        reviewsModel.getReviewText(),
                        reviewsModel.getRating(),
                        reviewsModel.getReviewDate()));
            }
        }

        gamesWithReviewsTo.setTitle(gamesModel.getTitle());
        gamesWithReviewsTo.setDescription(gamesModel.getDescription());
        gamesWithReviewsTo.setDeveloper(gamesModel.getDeveloper());
        gamesWithReviewsTo.setReleaseDate(gamesModel.getReleaseDate());
        gamesWithReviewsTo.setRating(gamesModel.getRating());
        gamesWithReviewsTo.setGenres(genresNameTos);
        gamesWithReviewsTo.setReviews(reviewsTos);

        return gamesWithReviewsTo;
    }

//    @Override
//    public ReviewsTo saveReviews(Integer gameId, CreateReviewsTo createReviewsTo){
//        GamesModel gamesModel = gamesRepository.findById(gameId).orElseThrow(InstanceNotFoundException::new);
//
//        ReviewsModel reviewsModel = reviewsModelMapper.toReviewsModel(createReviewsTo);
//
//        return null;
//    }

}
