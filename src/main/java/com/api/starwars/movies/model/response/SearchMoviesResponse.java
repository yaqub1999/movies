package com.api.starwars.movies.model.response;

import lombok.Data;

import java.util.List;

@Data
public class SearchMoviesResponse {
    private Integer count;
    private Integer next;
    private Integer previous;
    private List<MoviesResponse> results;
}
