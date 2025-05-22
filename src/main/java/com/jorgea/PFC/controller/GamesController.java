package com.jorgea.PFC.controller;

import com.jorgea.PFC.dto.*;
import com.jorgea.PFC.mapperDto.GamesDtoMapper;
import com.jorgea.PFC.service.GamesService;
import com.jorgea.PFC.to.*;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<GamesWithoutGenresDto> saveGames (@Valid @RequestBody GamesPostDto gamesPostDto){
        GamesPostTo gamesPostTo = gamesDtoMapper.toGamesPostTo(gamesPostDto);

        GamesWithoutGenresTo gamesWithoutGenresTo = gamesService.saveGames(gamesPostTo);

        return ResponseEntity.status(HttpStatus.CREATED).body(gamesDtoMapper.toGamesWithoutGenresDto(gamesWithoutGenresTo));
    }

    @PostMapping("/{gameId}/genres/{genreId}")
    public ResponseEntity<GamesGenresDto> addGenresToGames (@PathVariable Integer gameId, @PathVariable Integer genreId){
        GamesGenresTo gamesGenresTo = gamesService.addGenresToGames(gameId, genreId);

        GamesGenresDto gamesGenresDto = gamesDtoMapper.toGamesGenresDto(gamesGenresTo);

        return ResponseEntity.ok(gamesGenresDto);
    }

    @PutMapping("/{gameId}")
    public ResponseEntity<GamesWithoutGenresDto> updateGames(@PathVariable Integer gameId, @Valid @RequestBody GamesPutDto gamesPutDto){
        GamesPutTo gamesPutTo = gamesDtoMapper.toGamesPutTo(gamesPutDto);

        GamesWithoutGenresTo gamesWithoutGenresTo = gamesService.updateGames(gameId, gamesPutTo);

        return ResponseEntity.ok(gamesDtoMapper.toGamesWithoutGenresDto(gamesWithoutGenresTo));
    }

    @PatchMapping("/{gameId}")
    public ResponseEntity<GamesWithoutGenresDto> partialUpdateGames(@PathVariable Integer gameId, @Valid @RequestBody GamesPatchDto gamesPatchDto){
        GamesPatchTo gamesPatchTo = gamesDtoMapper.toGamesPatchTo(gamesPatchDto);

        GamesWithoutGenresTo gamesWithoutGenresTo = gamesService.partialUpdateGames(gameId, gamesPatchTo);

        return ResponseEntity.ok(gamesDtoMapper.toGamesWithoutGenresDto(gamesWithoutGenresTo));
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity<Void> deleteGames(@PathVariable Integer gameId){
        gamesService.deleteGames(gameId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{gameId}/genres/{genreId}")
    public ResponseEntity<Void> deleteGenresFromGames(@PathVariable Integer gameId, @PathVariable Integer genreId){
        gamesService.deleteGenresFromGames(gameId, genreId);

        return ResponseEntity.ok().build();
    }

}
