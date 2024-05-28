package com.popcorn.neo4j.controller;

import com.popcorn.neo4j.node.ActorNode;
import com.popcorn.neo4j.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/actors")
@RequiredArgsConstructor
@Slf4j
public class ActorController {
    private final ActorRepository actorRepository;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ActorNode>> getAllActors() {
        log.info("ActorController::getAllActors");
        return ResponseEntity.status(HttpStatus.OK)
                .body(actorRepository.findAll());
    }
}
