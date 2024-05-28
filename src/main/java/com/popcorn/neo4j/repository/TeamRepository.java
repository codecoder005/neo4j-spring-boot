package com.popcorn.neo4j.repository;

import com.popcorn.neo4j.node.TeamNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface TeamRepository extends Neo4jRepository<TeamNode, UUID> {

}
