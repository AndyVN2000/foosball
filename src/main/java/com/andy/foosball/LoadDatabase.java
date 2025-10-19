package com.andy.foosball;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.andy.foosball.domain.Player;
import com.andy.foosball.domain.PlayerRepository;


/**
 * Inspired by: https://spring.io/guides/tutorials/rest
 */

@Configuration
public class LoadDatabase {

@Bean
CommandLineRunner initDatabase(PlayerRepository repository) {
    return args -> {
        repository.save(Player.createPlayerWithDefaultHandicap("Foo Bar", "F.B"));
    };
}

}
