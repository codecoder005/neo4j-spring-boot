package com.popcorn.neo4j.node;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Node(value = "Person")
public class ActorNode {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer born;
}
