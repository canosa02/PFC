package com.jorgea.PFC.controller;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.dto.FilmsGenresDto;
import com.jorgea.PFC.dto.PageResponseDto;
import com.jorgea.PFC.mapperDto.FilmsDtoMapper;
import com.jorgea.PFC.mapperModel.FilmsModelMapper;
import com.jorgea.PFC.service.FilmsService;
import com.jorgea.PFC.to.FilmsGenresTo;
import com.jorgea.PFC.to.FilmsTo;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmsController {

    private final FilmsService filmsService;

    private final FilmsModelMapper filmsModelMapper;

    private final FilmsDtoMapper filmsDtoMapper;

    public FilmsController(FilmsService filmsService, FilmsModelMapper filmsModelMapper, FilmsDtoMapper filmsDtoMapper) {
        this.filmsService = filmsService;
        this.filmsModelMapper = filmsModelMapper;
        this.filmsDtoMapper = filmsDtoMapper;
    }

    @GetMapping("")
    public ResponseEntity<PageResponseDto<FilmsGenresDto>> findAllFilmsWithFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genreName,
            @PageableDefault(sort = "filmId", direction = Sort.Direction.ASC) Pageable pageable) {

        PageResponseTo<FilmsGenresTo> filmsDtoPageResponseTo = filmsService.findAllFilmsWithFilters(title, genreName, pageable);

        List<FilmsGenresDto> filmsDtoPageResponseDto = filmsDtoPageResponseTo.getContent().stream()
                .map(filmsDtoMapper::toFilmsGenresDto)
                .toList();

        PageResponseDto<FilmsGenresDto> response = new PageResponseDto<>(
                filmsDtoPageResponseDto,
                filmsDtoPageResponseDto.size(),
                1
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{filmId}")
    public ResponseEntity<FilmsGenresDto> findFilmById(@PathVariable Integer filmId) {
        FilmsGenresTo filmsGenresTo = filmsService.findByFilmId(filmId);

        return ResponseEntity.ok(filmsDtoMapper.toFilmsGenresDto(filmsGenresTo));
    }

}
