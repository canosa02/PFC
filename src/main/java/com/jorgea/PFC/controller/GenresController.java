package com.jorgea.PFC.controller;

import com.jorgea.PFC.dto.GamesGenresDto;
import com.jorgea.PFC.dto.GenresWithoutGamesDto;
import com.jorgea.PFC.dto.PageResponseDto;
import com.jorgea.PFC.mapperDto.GenresDtoMapper;
import com.jorgea.PFC.service.GenresService;
import com.jorgea.PFC.to.GenresWithoutGamesTo;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenresController {

    private final GenresService genresService;

    private final GenresDtoMapper genresDtoMapper;

    public GenresController(GenresService genresService, GenresDtoMapper genresDtoMapper) {
        this.genresService = genresService;
        this.genresDtoMapper = genresDtoMapper;
    }

    @GetMapping("")
    public ResponseEntity<PageResponseDto<GenresWithoutGamesDto>> findALlGenresWithFilters (
            @RequestParam(required = false) String genreName,
            @PageableDefault(sort = "genreId", direction = Sort.Direction.ASC) Pageable pageable) {

        PageResponseTo<GenresWithoutGamesTo> genresWithoutGamesToPageResponseTo = genresService.findALlGenresWithFilters(genreName, pageable);

        List<GenresWithoutGamesDto> genresWithoutGamesDtos = genresWithoutGamesToPageResponseTo.getContent().stream()
                .map(genresDtoMapper::toGenresWithoutGamesDto)
                .toList();

        PageResponseDto<GenresWithoutGamesDto> response = new PageResponseDto<>(
                genresWithoutGamesDtos,
                (int) genresWithoutGamesToPageResponseTo.getCurrentPage(),
                genresWithoutGamesToPageResponseTo.getTotalPages()
        );

        return ResponseEntity.ok(response);
    }



}
