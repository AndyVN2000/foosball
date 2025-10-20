package com.andy.foosball.presentation;

import org.springframework.web.bind.annotation.RestController;

import com.andy.foosball.application.MatchApplicationService;
import com.andy.foosball.domain.MatchRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class MatchController {
    private MatchRepository matchRepository;
    private MatchApplicationService matchApplicationService;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
        this.matchApplicationService = new MatchApplicationService(matchRepository);
    }

    @PutMapping(value = "/matches/{id}")
    void endMatch(@PathVariable("id") int id) {
        matchApplicationService.endMatch(id);
    }

}
