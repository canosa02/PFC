package com.jorgea.PFC.controller;

import com.jorgea.PFC.dto.GamesGenresDto;
import com.jorgea.PFC.dto.PageResponseDto;
import com.jorgea.PFC.mapperDto.GamesDtoMapper;
import com.jorgea.PFC.service.GamesService;
import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {

    private final GamesService gamesService;

    private final GamesDtoMapper gamesDtoMapper;

    public GamesController(GamesService gamesService, GamesDtoMapper gamesDtoMapper) {
        this.gamesService = gamesService;
        this.gamesDtoMapper = gamesDtoMapper;
    }

    @GetMapping("")
    public ResponseEntity<PageResponseDto<GamesGenresDto>> findAllGamesWithFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genreName,
            @PageableDefault(sort = "gameId", direction = Sort.Direction.ASC) Pageable pageable) {

        PageResponseTo<GamesGenresTo> gamesDtoPageResponseTo = gamesService.findAllGamesWithFilters(title, genreName, pageable);

        List<GamesGenresDto> gamesDtoPageResponseDto = gamesDtoPageResponseTo.getContent().stream()
                .map(gamesDtoMapper::toGamesGenresDto)
                .toList();

        PageResponseDto<GamesGenresDto> response = new PageResponseDto<>(
                gamesDtoPageResponseDto,
                gamesDtoPageResponseDto.size(),
                1
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GamesGenresDto> findGamesById(@PathVariable Integer gameId) {
        GamesGenresTo gamesGenresTo = gamesService.findByGameId(gameId);

        return ResponseEntity.ok(gamesDtoMapper.toGamesGenresDto(gamesGenresTo));
    }

}
