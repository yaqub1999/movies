package com.api.starwars.movies.model.request;

import lombok.Data;

@Data
public class MoviesFilter {
    private String title;
    private Integer episode_id;
    private String character;
    private String director;
}
