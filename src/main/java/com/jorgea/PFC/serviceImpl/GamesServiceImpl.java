package com.jorgea.PFC.serviceImpl;

import com.jorgea.PFC.exception.InstanceNotFoundException;
import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.model.GenresModel;
import com.jorgea.PFC.specification.GamesSpecification;
import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.GamesTo;
import com.jorgea.PFC.mapperModel.GamesModelMapper;
import com.jorgea.PFC.repository.GamesRepository;
import com.jorgea.PFC.service.GamesService;
import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GamesServiceImpl implements GamesService {

    private final GamesRepository gamesRepository;

    private final GamesModelMapper gamesModelMapper;

    public GamesServiceImpl(GamesRepository gamesRepository, GamesModelMapper gamesModelMapper) {
        this.gamesRepository = gamesRepository;
        this.gamesModelMapper = gamesModelMapper;
    }

    @Override
    public PageResponseTo<GamesGenresTo> findAllGamesWithFilters(String title, String genreName, Pageable pageable) {

        Specification<GamesModel> spec = Specification.where(null);

        if (title != null && !title.isBlank()) {
            spec = spec.and(GamesSpecification.hasTitle(title));
        }

        if (genreName != null && !genreName.isBlank()) {
            spec = spec.and(GamesSpecification.hasGenreName(genreName));
        }

        Page<GamesModel> gamesModels = gamesRepository.findAll(spec, pageable);

        List<GamesGenresTo> gamesGenresTos = new ArrayList<>();

        for (GamesModel gamesModel : gamesModels.getContent()) {
            List<GenresNameTo> genresNameTos = new ArrayList<>();

            if(gamesModel.getGenres() != null){
                for (GenresModel genresModel : gamesModel.getGenres()) {
                    genresNameTos.add(new GenresNameTo(genresModel.getGenreName()));
                }
            }
            gamesGenresTos.add(new GamesGenresTo(
                    gamesModel.getGameId(),
                    gamesModel.getTitle(),
                    gamesModel.getDescription(),
                    gamesModel.getDeveloper(),
                    gamesModel.getReleaseDate(),
                    gamesModel.getRating(),
                    genresNameTos
            ));
        }
        return new PageResponseTo<>(
                gamesGenresTos,
                gamesModels.getNumber(),
                gamesModels.getTotalPages()
        );
    }

    @Override
    public GamesGenresTo findByGamesId(@PathVariable Integer gameId) {

        Optional<GamesModel> gamesModel = gamesRepository.findById(gameId);

        if (gamesModel.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        GamesModel gamesModel1 = gamesModel.get();

        GamesGenresTo gamesGenresTo = new GamesGenresTo();
        gamesGenresTo.setGameId(gamesModel1.getGameId());
        gamesGenresTo.setTitle(gamesModel1.getTitle());
        gamesGenresTo.setDescription(gamesModel1.getDescription());
        gamesGenresTo.setDeveloper(gamesModel1.getDeveloper());
        gamesGenresTo.setReleaseDate(gamesModel1.getReleaseDate());
        gamesGenresTo.setRating(gamesModel1.getRating());

        List<GenresNameTo> genresNameTos = new ArrayList<>();

        for (GenresModel genresModel : gamesModel1.getGenres()) {
            genresNameTos.add(new GenresNameTo(genresModel.getGenreName()));
        }

        gamesGenresTo.setGenres(genresNameTos);

        return gamesGenresTo;
    }

    @Override
    public GamesTo saveGames(GamesTo gamesTo) {
        return null;
    }

    @Override
    public GamesTo updateGames(GamesTo gamesTo) {
        return null;
    }

    @Override
    public GamesTo partialUpdateGames(GamesTo gamesTo) {
        return null;
    }

    @Override
    public GamesTo deleteGames(GamesTo gamesTo) {
        return null;
    }
}
