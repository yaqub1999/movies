package com.api.starwars.movies.controller;

import com.api.starwars.movies.model.response.MoviesResponse;
import com.api.starwars.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MoviesService service;

    @GetMapping
    public MoviesResponse getMovieById(@RequestParam Integer movieId) {
            return this.service.getMovieById(movieId);

    }

    @GetMapping("/filter/character")
    public List<MoviesResponse> getMovieByCharacterName(@RequestParam String characterName) {
        return this.service.getMoviesByCharacter(characterName);
    }

    @GetMapping("/filter/title")
    public MoviesResponse getMovieByTitle(@RequestParam String title) {
        return this.service.getMovieByTitle(title);
    }

    @GetMapping("/filter/episode")
    public MoviesResponse getMovieByEpisodeId(@RequestParam Integer episodeId) {
        return this.service.getMovieByEpisodeId(episodeId);


    }

}
