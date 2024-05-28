package com.popcorn.neo4j.node;

import com.popcorn.neo4j.common.AppConstants;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Node(labels = "PLAYER")
public class PlayerNode {
    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID uuid;

    private String name;
    private Integer age;
    private Integer height;
    private Integer weight;

    @Relationship(AppConstants.Relationships.PLAYS_FOR)
    private TeamNode playsFor;

    @Relationship(AppConstants.Relationships.PLAYED_FOR)
    private List<TeamNode> playedFor;

    @Relationship(AppConstants.Relationships.CAPTAINS)
    private TeamNode captains;

    @Relationship(AppConstants.Relationships.CAPTAINED)
    private List<TeamNode> captained;
}
