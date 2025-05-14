package com.jorgea.PFC.serviceImpl;

import com.jorgea.PFC.FilmsSpecification;
import com.jorgea.PFC.to.FilmsTo;
import com.jorgea.PFC.mapperModel.FilmsModelMapper;
import com.jorgea.PFC.model.FilmsModel;
import com.jorgea.PFC.repository.FilmsRepository;
import com.jorgea.PFC.service.FilmsService;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

//    @Override
//    public PageResponseTo<FilmsTo> findAllFilmsWithFilters(String title, String genreName, Pageable pageable) {
//
//        Specification<FilmsModel> spec = Specification.where(null);
//
//        if (title != null && !title.isBlank()) {
//            spec = spec.and(FilmsSpecification.hasTitle(title));
//        }
//
//        if (genreName != null && !genreName.isBlank()) {
//            spec = spec.and(FilmsSpecification.hasGenreName(genreName));
//        }
//
//        Page<FilmsModel> filmsModels = filmsRepository.findAll(spec, pageable);
//
//
//    }

    @Override
    public FilmsTo findByFilmId(Integer filmId) {

        Optional<FilmsModel> filmsModel = filmsRepository.findById(filmId);

        if (filmsModel.isPresent()) {
            return
        }

        return null;
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
