package com.popcorn.neo4j.controller;

import com.popcorn.neo4j.model.CreateTeamRequest;
import com.popcorn.neo4j.node.TeamNode;
import com.popcorn.neo4j.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor
@Slf4j
public class TeamController {
    private final TeamRepository teamRepository;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TeamNode> createTeam(@RequestBody CreateTeamRequest request) {
        log.info("TeamController::createTeam");
        TeamNode teamNode = TeamNode.builder()
                .name(request.getName())
                .homeGround(request.getHomeGround())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(teamRepository.save(teamNode));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TeamNode>> getAllTeams() {
        log.info("TeamController::getAllTeams");
        return ResponseEntity.status(HttpStatus.OK)
                .body(teamRepository.findAll());
    }
}
