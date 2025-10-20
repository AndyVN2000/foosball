package com.andy.foosball.application;

import com.andy.foosball.application.exceptions.MatchNotFoundException;
import com.andy.foosball.domain.Match;
import com.andy.foosball.domain.MatchRepository;
import com.andy.foosball.domain.PlayerRepository;

public class MatchApplicationService {
    private MatchRepository matchRepository;

    public MatchApplicationService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void endMatch(int matchId) {
        Match match = matchRepository.findById(matchId)
            .orElseThrow(() -> new MatchNotFoundException());
        match.endMatch();
    }

}
