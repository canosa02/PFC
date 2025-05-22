package com.jorgea.PFC.service;

import com.jorgea.PFC.to.GenresWithoutGamesTo;
import com.jorgea.PFC.mapperModel.GenresModelMapper;
import com.jorgea.PFC.model.GenresModel;
import com.jorgea.PFC.repository.GenresRepository;
import com.jorgea.PFC.specification.GenresSpecification;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GenresServiceImpl implements GenresService{

    private final GenresRepository genresRepository;

    private final GenresModelMapper genresModelMapper;

    public GenresServiceImpl(GenresRepository genresRepository, GenresModelMapper genresModelMapper) {
        this.genresRepository = genresRepository;
        this.genresModelMapper = genresModelMapper;
    }

    @Override
    public PageResponseTo<GenresWithoutGamesTo> findALlGenresWithFilters(String genreName, Pageable pageable){

        Specification<GenresModel> spec = Specification.where(null);

        if (genreName != null){
            spec = spec.and(GenresSpecification.hasGenreName(genreName));
        }

        Page<GenresModel> genresModelPage = genresRepository.findAll(spec, pageable);

        List<GenresWithoutGamesTo> genresWithoutGamesTos = new ArrayList<>();

        for (GenresModel genresModel : genresModelPage) {
            genresWithoutGamesTos.add(new GenresWithoutGamesTo(
                    genresModel.getGenreId(),
                    genresModel.getGenreName()
            ));
        }

        return new PageResponseTo<>(
                genresWithoutGamesTos,
                genresModelPage.getPageable().getPageNumber() + 1,
                genresModelPage.getTotalPages()
        );

    }

}
