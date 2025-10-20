package com.andy.foosball.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Match {
    private @Id int matchId;
    private List<Player> team0;
    private List<Player> team1;

    public Match(){
        team0 = new ArrayList<>();
        team1 = new ArrayList<>();
    }

}
