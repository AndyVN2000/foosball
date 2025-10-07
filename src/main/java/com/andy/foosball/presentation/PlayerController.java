package com.andy.foosball.presentation;

import com.andy.foosball.application.PlayerApplicationService;
import com.andy.foosball.application.PlayerSummary;
import com.andy.foosball.domain.Player;
import com.andy.foosball.domain.PlayerRepository;
import com.andy.foosball.infrastructure.InMemoryPlayerRepository;

import java.util.List;
import java.util.OptionalInt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * https://spring.io/guides/tutorials/rest
 */
@RestController
public class PlayerController {
    PlayerRepository playerRepository;
    PlayerApplicationService playerApplicationService;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = new InMemoryPlayerRepository();
        this.playerApplicationService = new PlayerApplicationService(this.playerRepository);
    }

    /**
     * Jeg ser i eksempler at signaturen af en POST metode returnere entity.
     * Det giver dog ikke helt mening i mit hoved. POST har formålet i blot at
     * oprette og indsætte en entity i databasen. Så jeg overvejer at ændre returtype
     * til `void`.
     */
    @PostMapping("/players")
    Player newPlayer(@RequestBody Player player) {
        System.out.println("Invoked POST to create new player");
        playerApplicationService.createPlayer(
            player.getName(),
            player.getInitials(),
            OptionalInt.of(player.getHandicap()));
        return player;
    }

    /**
     * Hvad jeg har lært, så har man DTO'er som substitut til at skjule indholdet af Domain entities.
     * Jeg er ikke 100% sikker på at min GET metode skal så returnere en DTO (PlayerSummary) eller ej.
     * Men det giver mest mening i mit hoved hvis det gør.
     */
    @GetMapping("/players/{name}")
    PlayerSummary getPlayer(@PathVariable String name) {
        return playerApplicationService.findPlayerByName(name);
    }

    @GetMapping("/players")
    List<Player> getAllPlayers() {
        System.out.println("INVOKED GET ALL PLAYERS");
        return playerRepository.findAll();
    }

}
