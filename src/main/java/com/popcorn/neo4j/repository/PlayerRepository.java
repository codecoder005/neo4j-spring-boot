package com.popcorn.neo4j.repository;

import com.popcorn.neo4j.node.PlayerNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface PlayerRepository extends Neo4jRepository<PlayerNode, UUID> {

}
