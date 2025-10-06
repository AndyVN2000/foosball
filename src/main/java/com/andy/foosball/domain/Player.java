package com.andy.foosball.domain;

public class Player {

    private String name;
    private String initials;
    private int handicap = 10;

    private Player(String name, String initials, int handicap) {
        this.name = name;
        this.initials = initials;
        this.handicap = handicap;
    }

    public static Player createPlayerWithDefaultHandicap(String name, String initials) {
        return new Player(name, initials, 10);
    }

    public static Player createPlayer(String name, String initials, int handicap) {
        return new Player(name, initials, handicap);
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setInitials(String newInitials) {
        initials = newInitials;
    }

}
