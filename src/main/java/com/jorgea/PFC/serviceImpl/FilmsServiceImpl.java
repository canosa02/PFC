package com.jorgea.PFC.serviceImpl;

import com.jorgea.PFC.FilmsSpecification;
import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.dto.PageResponseDto;
import com.jorgea.PFC.mapper.FilmsMapper;
import com.jorgea.PFC.model.FilmsModel;
import com.jorgea.PFC.repository.FilmsRepository;
import com.jorgea.PFC.service.FilmsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FilmsServiceImpl implements FilmsService {

    private final FilmsRepository filmsRepository;

    private final FilmsMapper filmsMapper;

    public FilmsServiceImpl(FilmsRepository filmsRepository, FilmsMapper filmsMapper) {
        this.filmsRepository = filmsRepository;
        this.filmsMapper = filmsMapper;
    }

    @Override
    public PageResponseDto<FilmsDto> findAllFilmsWithFilters(String title, String genreName, Pageable pageable) {

        Specification<FilmsModel> spec = Specification.where(null);

        if (title != null && !title.isBlank()) {
            spec = spec.and(FilmsSpecification.hasTitle(title));
        }

        if (genreName != null && !genreName.isBlank()) {
            spec = spec.and(FilmsSpecification.hasGenreName(genreName));
        }

        Page<FilmsModel> filmsModels = filmsRepository.findAll(spec, pageable);

    }

    @Override
    public FilmsDto findByFilmId(Integer filmId) {
        return null;
    }

    @Override
    public FilmsDto saveFilms(FilmsDto filmsDto) {
        return null;
    }

    @Override
    public FilmsDto updateFilms(FilmsDto filmsDto) {
        return null;
    }

    @Override
    public FilmsDto partialUpdateFiles(FilmsDto filmsDto) {
        return null;
    }

    @Override
    public FilmsDto deleteFilms(FilmsDto filmsDto) {
        return null;
    }
}
