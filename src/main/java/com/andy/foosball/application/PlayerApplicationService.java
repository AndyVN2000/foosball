package com.andy.foosball.application;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.lang.Integer;

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

    /**
     * Normalt er det Repository classes der har ansvaret for at holde på logikken i at fx
     * sortere efter handicap. Men for nu holder jeg alt logikken i ApplicationService.
     * Angående den konkrete sortering fandt jeg inspiration herfra: https://stackoverflow.com/questions/40517977/sorting-a-list-with-stream-sorted-in-java
     * */
    public List<PlayerSummary> listAllPlayers() {
        return playerRepository.findAll().stream().
            sorted(
                (p0, p1) -> 
                    Integer.valueOf(p0.getHandicap()).compareTo(Integer.valueOf(p1.getHandicap()))
                ).
            map(
                player -> {
                    return new PlayerSummary(
                        player.getName(), 
                        player.getInitials(), 
                        player.getHandicap()
                    );
            }).
            collect(Collectors.toList());
    }

}
