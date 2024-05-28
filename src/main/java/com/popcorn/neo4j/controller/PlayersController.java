package com.popcorn.neo4j.controller;

import com.popcorn.neo4j.model.CreateNewPlayerRequest;
import com.popcorn.neo4j.node.PlayerNode;
import com.popcorn.neo4j.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
@RequiredArgsConstructor
@Slf4j
public class PlayersController {
    private final PlayerRepository playerRepository;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PlayerNode> createPlayer(@RequestBody CreateNewPlayerRequest request) {
        log.info("PlayersController::createPlayer");
        PlayerNode playerNode = PlayerNode.builder()
                .name(request.getName())
                .age(request.getAge())
                .height(request.getHeight())
                .weight(request.getWeight())
                .build();
        playerNode = playerRepository.save(playerNode);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(playerNode);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PlayerNode>> getAllPlayers() {
        log.info("PlayersController::getAllPlayers");
        return ResponseEntity.status(HttpStatus.OK)
                .body(playerRepository.findAll());
    }
}
