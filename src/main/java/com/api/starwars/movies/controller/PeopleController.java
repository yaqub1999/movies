package com.api.starwars.movies.controller;


import com.api.starwars.movies.model.response.PeopleResponse;
import com.api.starwars.movies.model.response.SearchPeopleResponse;
import com.api.starwars.movies.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService service;

    @GetMapping
    public PeopleResponse getPeopleByName(@RequestParam String name) {
        return this.service.getPeople(name);
    }

    @GetMapping("/all")
    public SearchPeopleResponse getAllPeople() {
        return this.service.getAllPeople();
    }

}


