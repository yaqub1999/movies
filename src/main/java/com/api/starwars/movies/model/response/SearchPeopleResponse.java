package com.api.starwars.movies.model.response;

import lombok.Data;

import java.util.List;
@Data
public class SearchPeopleResponse {
    private Integer count;
    private Integer next;
    private Integer previous;
    private List<PeopleResponse> results;
}
