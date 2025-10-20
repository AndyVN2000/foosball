package com.andy.foosball;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.andy.foosball.application.TeamApplicationService;
import com.andy.foosball.domain.Match;
import com.andy.foosball.domain.MatchRepository;
import com.andy.foosball.domain.Player;
import com.andy.foosball.domain.PlayerRepository;
import com.andy.foosball.domain.Team;


/**
 * Inspired by: https://spring.io/guides/tutorials/rest
 */

@Configuration
public class LoadDatabase {

@Bean
CommandLineRunner initDatabase(PlayerRepository playerRepository, MatchRepository matchRepository) {
    return args -> {
        matchRepository.save(new Match(0));
        playerRepository.save(Player.createPlayerWithDefaultHandicap("Foo Bar", "F.B."));
        playerRepository.save(Player.createPlayerWithDefaultHandicap("Baz Bar", "B.B."));
        playerRepository.save(Player.createPlayer("Joe", "J", 15));
        playerRepository.save(Player.createPlayer("Schmoe", "S", 20));
        TeamApplicationService teamApplicationService = new TeamApplicationService(matchRepository, playerRepository);
        teamApplicationService.addPlayersToTeamInMatch("Foo Bar", "Baz Bar", Team.RED, 0);
        teamApplicationService.addPlayersToTeamInMatch("Joe", "Schmoe", Team.BLUE, 0);
    };
}

}
