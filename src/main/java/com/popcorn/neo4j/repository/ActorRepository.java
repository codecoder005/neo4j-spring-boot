package com.popcorn.neo4j.repository;

import com.popcorn.neo4j.node.ActorNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ActorRepository extends Neo4jRepository<ActorNode, Long> {

}
