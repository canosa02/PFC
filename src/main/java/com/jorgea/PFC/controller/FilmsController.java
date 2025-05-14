package com.jorgea.PFC.controller;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.dto.PageResponseDto;
import com.jorgea.PFC.mapper.FilmsMapper;
import com.jorgea.PFC.model.FilmsModel;
import com.jorgea.PFC.service.FilmsService;
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
@RequestMapping("/films")
public class FilmsController {

    private final FilmsService filmsService;

    private final FilmsMapper filmsMapper;

    public FilmsController(FilmsService filmsService, FilmsMapper filmsMapper) {
        this.filmsService = filmsService;
        this.filmsMapper = filmsMapper;
    }

    @GetMapping("")
    public ResponseEntity<PageResponseDto<FilmsDto>> findAllFilmsWithFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genreName,
            @PageableDefault(sort = "filmsId", direction = Sort.Direction.ASC) Pageable pageable) {

        PageResponseDto<FilmsDto> filmsDtoPageResponseDto = filmsService.findAllFilmsWithFilters(title, genreName, pageable);

        return ResponseEntity.ok(filmsDtoPageResponseDto);
    }

}
