package com.popcorn.neo4j.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTeamRequest {
    private String name;
    private String homeGround;
}
