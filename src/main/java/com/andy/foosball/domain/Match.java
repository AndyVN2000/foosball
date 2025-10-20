package com.andy.foosball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Match {
    private final @Id Integer matchId;
    private @OneToMany List<Player> redTeam;
    private @OneToMany List<Player> blueTeam;
    private Team winnerTeam;

    public Match(int id){
        matchId = id;
    }

    /**
     * Not really proud of this. Surely there must be a better way...
     * @param team
     * @param player0
     * @param player1
     */
    public void setTeam(Team team, Player player0, Player player1) {
        if (team == Team.RED) {
            redTeam = Arrays.asList(player0, player1);
        } else {
            blueTeam = Arrays.asList(player0, player1);
        }
    }

    public void setWinner(Team team) {
        winnerTeam = team;
    }

    /**
     * Again, not really proud of this. There must be a better way
     */
    public void endMatch() {
        if (winnerTeam == Team.RED) {
            for(Player player : redTeam) {
                player.incrementHandicap();
            }
            for(Player player : blueTeam) {
                player.decrementHandicap();
            }
        } else {
            for(Player player : blueTeam) {
                player.incrementHandicap();
            }
            for(Player player : redTeam) {
                player.decrementHandicap();
            }
        }
    }

}
