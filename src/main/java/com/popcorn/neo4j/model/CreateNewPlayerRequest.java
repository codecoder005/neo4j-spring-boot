package com.popcorn.neo4j.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewPlayerRequest {
    private String name;
    private Integer age;
    private Integer height;
    private Integer weight;
}
