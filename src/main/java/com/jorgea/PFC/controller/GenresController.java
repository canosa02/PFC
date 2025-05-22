package com.jorgea.PFC.controller;

import com.jorgea.PFC.dto.GamesGenresDto;
import com.jorgea.PFC.dto.GenresNameDto;
import com.jorgea.PFC.dto.GenresWithoutGamesDto;
import com.jorgea.PFC.dto.PageResponseDto;
import com.jorgea.PFC.mapperDto.GenresDtoMapper;
import com.jorgea.PFC.service.GenresService;
import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.GenresWithoutGamesTo;
import com.jorgea.PFC.to.PageResponseTo;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{genreId}")
    public ResponseEntity<GenresWithoutGamesDto> findByGenreId (@PathVariable Integer genreId) {
        GenresWithoutGamesTo genresWithoutGamesTo = genresService.findByGenreId(genreId);

        return ResponseEntity.ok(genresDtoMapper.toGenresWithoutGamesDto(genresWithoutGamesTo));
    }

    @PostMapping("")
    public ResponseEntity<GenresWithoutGamesDto> saveGenres (@Valid @RequestBody GenresNameDto genresNameDto){
        GenresNameTo genresNameTo = genresDtoMapper.toGenresNameTo(genresNameDto);

        GenresWithoutGamesTo genresWithoutGamesTo = genresService.saveGenres(genresNameTo);

        GenresWithoutGamesDto genresWithoutGamesDto = genresDtoMapper.toGenresWithoutGamesDto(genresWithoutGamesTo);

        return ResponseEntity.status(HttpStatus.CREATED).body(genresWithoutGamesDto);
    }

}
