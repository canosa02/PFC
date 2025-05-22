package com.jorgea.PFC.service;

import com.jorgea.PFC.exception.ConflictException;
import com.jorgea.PFC.exception.InstanceNotFoundException;
import com.jorgea.PFC.mapperModel.GamesModelMapper;
import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.model.GenresInGames;
import com.jorgea.PFC.model.GenresModel;
import com.jorgea.PFC.repository.GamesRepository;
import com.jorgea.PFC.repository.GenresInGamesRepository;
import com.jorgea.PFC.repository.GenresRepository;
import com.jorgea.PFC.specification.GamesSpecification;
import com.jorgea.PFC.to.*;
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

    private final GenresRepository genresRepository;

    private final GenresInGamesRepository genresInGamesRepository;

    private final GamesModelMapper gamesModelMapper;

    public GamesServiceImpl(GamesRepository gamesRepository, GenresRepository genresRepository, GenresInGamesRepository genresInGamesRepository, GamesModelMapper gamesModelMapper) {
        this.gamesRepository = gamesRepository;
        this.genresRepository = genresRepository;
        this.genresInGamesRepository = genresInGamesRepository;
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

        Page<GamesModel> gamesModelPage = gamesRepository.findAll(spec, pageable);

        List<GamesGenresTo> gamesGenresTos = new ArrayList<>();

        for (GamesModel gamesModel : gamesModelPage.getContent()) {
            List<GenresNameTo> genresNameTos = new ArrayList<>();

            if (gamesModel.getGenres() != null) {
                for (GenresInGames genresInGames : gamesModel.getGenres()) {
                    genresNameTos.add(new GenresNameTo(genresInGames.getGenre().getGenreName()));
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
                gamesModelPage.getPageable().getPageNumber() + 1,
                gamesModelPage.getTotalPages()
        );
    }

    @Override
    public GamesGenresTo findByGameId(@PathVariable Integer gameId) {

        Optional<GamesModel> gamesModelOptional = gamesRepository.findById(gameId);

        if (gamesModelOptional.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        GamesModel gamesModel1 = gamesModelOptional.get();

        GamesGenresTo gamesGenresTo = new GamesGenresTo();
        gamesGenresTo.setGameId(gamesModel1.getGameId());
        gamesGenresTo.setTitle(gamesModel1.getTitle());
        gamesGenresTo.setDescription(gamesModel1.getDescription());
        gamesGenresTo.setDeveloper(gamesModel1.getDeveloper());
        gamesGenresTo.setReleaseDate(gamesModel1.getReleaseDate());
        gamesGenresTo.setRating(gamesModel1.getRating());

        List<GenresNameTo> genresNameTos = new ArrayList<>();

        for (GenresInGames genresInGames : gamesModel1.getGenres()) {
            genresNameTos.add(new GenresNameTo(genresInGames.getGenre().getGenreName()));
        }

        gamesGenresTo.setGenres(genresNameTos);

        return gamesGenresTo;
    }

    @Override
    public GamesWithoutGenresTo saveGames(GamesPostTo gamesPostTo) {
        GamesModel gamesModel = gamesModelMapper.toGamesModel(gamesPostTo);

        GamesModel savedGame = gamesRepository.save(gamesModel);

        return gamesModelMapper.toGamesWithoutGenresTo(savedGame);
    }

    @Override
    public GamesGenresTo addGenresToGames(Integer gameId, Integer genreId){
        Optional<GamesModel> gamesModelOptional = gamesRepository.findById(gameId);
        Optional<GenresModel> genresModelOptional = genresRepository.findById(genreId);
        Optional<GenresInGames> genresInGamesOptional = genresInGamesRepository.findByGame_GameIdAndGenre_GenreId(gameId, genreId);

        if(gamesModelOptional.isEmpty() || genresModelOptional.isEmpty()){
            throw new InstanceNotFoundException();
        }

        if(genresInGamesOptional.isPresent()){
            throw new ConflictException();
        }

        GamesModel gamesModel = gamesModelOptional.get();
        GenresModel genresModel = genresModelOptional.get();

        GamesGenresTo gamesGenresTo = new GamesGenresTo();
        gamesGenresTo.setGameId(gamesModel.getGameId());
        gamesGenresTo.setTitle(gamesModel.getTitle());
        gamesGenresTo.setDescription(gamesModel.getDescription());
        gamesGenresTo.setDeveloper(gamesModel.getDeveloper());
        gamesGenresTo.setReleaseDate(gamesModel.getReleaseDate());
        gamesGenresTo.setRating(gamesModel.getRating());

        List<GenresNameTo> genresNameTos = new ArrayList<>();

        if (gamesModel.getGenres() != null) {
            for (GenresInGames genresInGames : gamesModel.getGenres()) {
                genresNameTos.add(new GenresNameTo(genresInGames.getGenre().getGenreName()));
            }
        }

        genresNameTos.add(new GenresNameTo(genresModel.getGenreName()));

        gamesGenresTo.setGenres(genresNameTos);

        gamesGenresTo.setGenres(genresNameTos);

        GenresInGames genresInGames = new GenresInGames();
        genresInGames.setGame(gamesModel);
        genresInGames.setGenre(genresModel);

        genresInGamesRepository.save(genresInGames);

        return gamesGenresTo;
    }

    @Override
    public GamesWithoutGenresTo updateGames(Integer gameId, GamesPutTo gamesPutTo) {
        Optional<GamesModel> gamesModelOptional = gamesRepository.findById(gameId);

        if (gamesModelOptional.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        GamesModel gamesModel = gamesModelOptional.get();
        gamesModel.setTitle(gamesPutTo.getTitle());
        gamesModel.setDescription(gamesPutTo.getDescription());
        gamesModel.setDeveloper(gamesPutTo.getDeveloper());
        gamesModel.setReleaseDate(gamesPutTo.getReleaseDate());
        gamesModel.setRating(gamesPutTo.getRating());

        return gamesModelMapper.toGamesWithoutGenresTo(gamesModel);
    }

    @Override
    public GamesWithoutGenresTo partialUpdateGames(Integer gameId, GamesPatchTo gamesPatchTo) {
        Optional<GamesModel> gamesModelOptional = gamesRepository.findById(gameId);

        if (gamesModelOptional.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        GamesModel gamesModel = gamesModelOptional.get();

        if (gamesPatchTo.getTitle() != null && !gamesPatchTo.getTitle().isBlank()) {
            gamesModel.setTitle(gamesPatchTo.getTitle());
        }

        if (gamesPatchTo.getDescription() != null && !gamesPatchTo.getDescription().isBlank()){
            gamesModel.setDescription(gamesPatchTo.getDescription());
        }

        if (gamesPatchTo.getDeveloper() != null && !gamesPatchTo.getDeveloper().isBlank()){
            gamesModel.setDeveloper(gamesPatchTo.getDeveloper());
        }

        if (gamesPatchTo.getReleaseDate() != null && !gamesPatchTo.getReleaseDate().isBlank()){
            gamesModel.setReleaseDate(gamesPatchTo.getReleaseDate());
        }

        if (gamesPatchTo.getRating() != 0){
            gamesModel.setRating(gamesPatchTo.getRating());
        }

        return gamesModelMapper.toGamesWithoutGenresTo(gamesModel);
    }

    @Override
    public void deleteGames(Integer gameId) {
        Optional<GamesModel> gamesModelOptional = gamesRepository.findById(gameId);

        if (gamesModelOptional.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        GamesModel gamesModel = gamesModelOptional.get();

        gamesRepository.delete(gamesModel);
    }

    @Override
    public void deleteGenresFromGames(Integer gameId, Integer genreId) {
        Optional<GamesModel> gamesModelOptional = gamesRepository.findById(gameId);
        Optional<GenresModel> genresModelOptional = genresRepository.findById(genreId);
        Optional<GenresInGames> genresInGamesOptional = genresInGamesRepository.findByGame_GameIdAndGenre_GenreId(gameId, genreId);

        if (gamesModelOptional.isEmpty() || genresModelOptional.isEmpty() || genresInGamesOptional.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        GenresInGames genresInGames = genresInGamesOptional.get();

        genresInGamesRepository.delete(genresInGames);
    }
}
