package com.andy.foosball.application;

import com.andy.foosball.application.exceptions.PlayerNotFoundException;
import com.andy.foosball.domain.Match;
import com.andy.foosball.domain.Player;
import com.andy.foosball.domain.MatchRepository;
import com.andy.foosball.domain.PlayerRepository;
import com.andy.foosball.domain.Team;

/**
 * This class is responsible for the orchestration and setup of matches and its players
 * such as assigning players into two teams for a given match.
 */
public class TeamApplicationService {
    private MatchRepository matchRepository;
    private PlayerRepository playerRepository;

    public TeamApplicationService(MatchRepository matchRepository, PlayerRepository playerRepository) {
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

    public void addPlayersToTeamInMatch(String player0Name, String player1Name, Team team, int matchId) {
        Match match = matchRepository.getReferenceById(matchId);
        Player player0 = playerRepository.findByName(player0Name)
            .orElseThrow(() -> new PlayerNotFoundException());
        Player player1 = playerRepository.findByName(player1Name)
        .orElseThrow(() -> new PlayerNotFoundException());

        match.setTeam(team, player0, player1);
    }

}
