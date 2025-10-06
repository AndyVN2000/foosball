package com.andy.foosball.application;

import java.util.Optional;
import java.util.OptionalInt;

import com.andy.foosball.application.exceptions.PlayerNotFoundException;
import com.andy.foosball.domain.Player;
import com.andy.foosball.domain.PlayerRepository;

public class PlayerApplicationService {
    private PlayerRepository playerRepository;

    public PlayerApplicationService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void createPlayer(String name, String initials, OptionalInt handicap) {
        Player newPlayer = Player.createPlayer(name, initials, handicap.orElse(10));
    }

    /**
     * Jeg laver to delete metoder. Den ene sletter du gennem Player name og den anden sletter
     * du gennem Player initials. Dette er fordi specifikationen skelner mellem at søge en 
     * spiller gennem name eller initials.
     * @param name
     */
    public void deletePlayerByName(String name) {
        Player player = playerRepository.findByName(name).
            orElseThrow(() -> new PlayerNotFoundException());
        playerRepository.delete(player);
    }

    public void deletePlayerByInitials(String initials) {
        Player player = playerRepository.findByInitials(initials).
            orElseThrow(() -> new PlayerNotFoundException());
        playerRepository.delete(player);
    }

}
