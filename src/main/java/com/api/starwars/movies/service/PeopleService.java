package com.api.starwars.movies.service;

import com.api.starwars.movies.model.response.SearchPeopleResponse;
import com.api.starwars.movies.model.response.PeopleResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class PeopleService {

    private final Logger LOGGER = LoggerFactory.getLogger("Logger");

    public SearchPeopleResponse getAllPeople() {
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        SearchPeopleResponse response = null;
        try {
            response = restTemplate.getForObject("https://swapi.dev/api/people/",
                    SearchPeopleResponse.class);
        } catch (RestClientException e) {
            LOGGER.error("Erro na chamada HTTP GET da url https://swapi.dev/api/people/");
            e.printStackTrace();
        }
        return response;
    }

    public PeopleResponse getPeople(String characterName) {
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        SearchPeopleResponse response = null;
        try {
            response = restTemplate.getForObject("https://swapi.dev/api/people?search=" + characterName,
                    SearchPeopleResponse.class);
        } catch (RestClientException e) {
            LOGGER.error("Erro na chamada HTTP GET da url https://swapi.dev/api/people/");
            e.printStackTrace();
        }
        return response.getResults().get(0);
    }


}
