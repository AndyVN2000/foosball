package com.andy.foosball.application;

import com.andy.foosball.domain.MatchRepository;
import com.andy.foosball.domain.PlayerRepository;

public class MatchApplicationService {
    private MatchRepository matchRepository;

    public MatchApplicationService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void endMatch(int matchId) {
        matchRepository.getReferenceById(matchId).endMatch();
    }

}
