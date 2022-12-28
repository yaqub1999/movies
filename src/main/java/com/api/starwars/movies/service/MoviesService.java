package com.api.starwars.movies.service;


import com.api.starwars.movies.model.response.MoviesResponse;
import com.api.starwars.movies.model.response.PeopleResponse;
import com.api.starwars.movies.model.response.SearchMoviesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService {

    private final Logger LOGGER = LoggerFactory.getLogger("Logger");

    @Autowired
    private PeopleService peopleService;

    public MoviesResponse getMovieById(Integer movieId) {
        LOGGER.info("CHAMADA CHEGOU");
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        MoviesResponse response = null;
        try {
            response = restTemplate.getForObject("https://swapi.dev/api/films/" + movieId.toString(),
                    MoviesResponse.class);
        } catch (RestClientException e) {
            LOGGER.error("Erro na chamada HTTP GET da url https://swapi.dev/api/films/");
            e.printStackTrace();
        }
        return response;
    }

    public List<MoviesResponse> getMoviesByCharacter(String characterName) {

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        PeopleResponse character = peopleService.getPeople(characterName);
        List<MoviesResponse> response = new ArrayList<>();
        for (String urlFilm : character.getFilms()) {
            response.add(restTemplate.getForObject(urlFilm, MoviesResponse.class));
        }

         return response;
    }

    public MoviesResponse getMovieByTitle(String title) {
            RestTemplate restTemplate = new RestTemplate();
            RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
            restTemplate = restTemplateBuilder.build();
            SearchMoviesResponse response = null;
            try {
                response = restTemplate.getForObject("https://swapi.dev/api/films/",
                        SearchMoviesResponse.class);
            } catch (RestClientException e) {
                LOGGER.error("Erro na chamada HTTP GET da url https://swapi.dev/api/films/");
                e.printStackTrace();
            }

            return response.getResults().stream().filter(
                    filter -> filter.getTitle().equals(title)
            ).toList().get(0);
    }

    public MoviesResponse getMovieByEpisodeId(Integer episodeId) {
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        SearchMoviesResponse response = null;
        try {
            response = restTemplate.getForObject("https://swapi.dev/api/films/",
                    SearchMoviesResponse.class);
        } catch (RestClientException e) {
            LOGGER.error("Erro na chamada HTTP GET da url https://swapi.dev/api/films/");
            e.printStackTrace();
        }



        return response.getResults().stream().filter(
                filter -> filter.getEpisode_id() == episodeId
        ).toList().get(0);
    }

}
