package com.jorgea.PFC.serviceImpl;

import com.jorgea.PFC.exception.InstanceNotFoundException;
import com.jorgea.PFC.model.GenresModel;
import com.jorgea.PFC.specification.FilmsSpecification;
import com.jorgea.PFC.to.FilmsGenresTo;
import com.jorgea.PFC.to.FilmsTo;
import com.jorgea.PFC.mapperModel.FilmsModelMapper;
import com.jorgea.PFC.model.FilmsModel;
import com.jorgea.PFC.repository.FilmsRepository;
import com.jorgea.PFC.service.FilmsService;
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
public class FilmsServiceImpl implements FilmsService {

    private final FilmsRepository filmsRepository;

    private final FilmsModelMapper filmsModelMapper;

    public FilmsServiceImpl(FilmsRepository filmsRepository, FilmsModelMapper filmsModelMapper) {
        this.filmsRepository = filmsRepository;
        this.filmsModelMapper = filmsModelMapper;
    }

    @Override
    public PageResponseTo<FilmsGenresTo> findAllFilmsWithFilters(String title, String genreName, Pageable pageable) {

        Specification<FilmsModel> spec = Specification.where(null);

        if (title != null && !title.isBlank()) {
            spec = spec.and(FilmsSpecification.hasTitle(title));
        }

        if (genreName != null && !genreName.isBlank()) {
            spec = spec.and(FilmsSpecification.hasGenreName(genreName));
        }

        Page<FilmsModel> filmsModels = filmsRepository.findAll(spec, pageable);

        List<FilmsGenresTo> filmsGenresTos = new ArrayList<>();

        for (FilmsModel filmsModel : filmsModels.getContent()) {
            List<GenresNameTo> genresNameTos = new ArrayList<>();

            if(filmsModel.getGenres() != null){
                for (GenresModel genresModel : filmsModel.getGenres()) {
                    genresNameTos.add(new GenresNameTo(genresModel.getGenreName()));
                }
            }
            filmsGenresTos.add(new FilmsGenresTo(
                    filmsModel.getFilmId(),
                    filmsModel.getTitle(),
                    filmsModel.getDescription(),
                    filmsModel.getDirector(),
                    filmsModel.getReleaseDate(),
                    filmsModel.getRating(),
                    genresNameTos
            ));
        }
        return new PageResponseTo<>(
                filmsGenresTos,
                filmsModels.getNumber(),
                filmsModels.getTotalPages()
        );
    }

    @Override
    public FilmsGenresTo findByFilmId(@PathVariable Integer filmId) {

        Optional<FilmsModel> filmsModel = filmsRepository.findById(filmId);

        if (filmsModel.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        FilmsModel filmsModel1 = filmsModel.get();

        FilmsGenresTo filmsGenresTo = new FilmsGenresTo();
        filmsGenresTo.setFilmId(filmsModel1.getFilmId());
        filmsGenresTo.setTitle(filmsModel1.getTitle());
        filmsGenresTo.setDescription(filmsModel1.getDescription());
        filmsGenresTo.setDirector(filmsModel1.getDirector());
        filmsGenresTo.setReleaseDate(filmsModel1.getReleaseDate());
        filmsGenresTo.setRating(filmsModel1.getRating());

        List<GenresNameTo> genresNameTos = new ArrayList<>();

        for (GenresModel genresModel : filmsModel1.getGenres()) {
            genresNameTos.add(new GenresNameTo(genresModel.getGenreName()));
        }

        filmsGenresTo.setGenres(genresNameTos);

        return filmsGenresTo;
    }

    @Override
    public FilmsTo saveFilms(FilmsTo filmsTo) {
        return null;
    }

    @Override
    public FilmsTo updateFilms(FilmsTo filmsTo) {
        return null;
    }

    @Override
    public FilmsTo partialUpdateFiles(FilmsTo filmsTo) {
        return null;
    }

    @Override
    public FilmsTo deleteFilms(FilmsTo filmsTo) {
        return null;
    }
}
