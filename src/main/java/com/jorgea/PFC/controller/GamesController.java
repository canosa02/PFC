package com.jorgea.PFC.controller;

import com.jorgea.PFC.dto.GamesDto;
import com.jorgea.PFC.dto.GamesGenresDto;
import com.jorgea.PFC.dto.PageResponseDto;
import com.jorgea.PFC.dto.SaveGamesDto;
import com.jorgea.PFC.mapperDto.GamesDtoMapper;
import com.jorgea.PFC.service.GamesService;
import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.GamesTo;
import com.jorgea.PFC.to.PageResponseTo;
import com.jorgea.PFC.to.SaveGamesTo;
import jakarta.validation.Valid;
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

        PageResponseTo<GamesGenresTo> gamesToPageResponseTo = gamesService.findAllGamesWithFilters(title, genreName, pageable);

        List<GamesGenresDto> gamesDtoPageResponseDto = gamesToPageResponseTo.getContent().stream()
                .map(gamesDtoMapper::toGamesGenresDto)
                .toList();

        PageResponseDto<GamesGenresDto> response = new PageResponseDto<>(
                gamesDtoPageResponseDto,
                (int) gamesToPageResponseTo.getCurrentPage(),
                gamesToPageResponseTo.getTotalPages()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GamesGenresDto> findGamesById(@PathVariable Integer gameId) {
        GamesGenresTo gamesGenresTo = gamesService.findByGameId(gameId);

        return ResponseEntity.ok(gamesDtoMapper.toGamesGenresDto(gamesGenresTo));
    }

    @PostMapping("")
    public ResponseEntity<GamesDto> saveGames (@Valid @RequestBody SaveGamesDto saveGamesDto){
        SaveGamesTo saveGamesTo = gamesDtoMapper.toSaveGamesTo(saveGamesDto);

        GamesTo gamesTo = gamesService.saveGames(saveGamesTo);

        return ResponseEntity.ok(gamesDtoMapper.toGamesDto(gamesTo));
    }

}
