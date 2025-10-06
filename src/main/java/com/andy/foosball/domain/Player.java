package com.andy.foosball.domain;

public class Player {

    private String name;
    private String initials;
    private int handicap = 10;

    private Player(String name, String initials) {
        this.name = name;
        this.initials = initials;
    }

    public static Player of(String name, String initials) {
        return new Player(name, initials);
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setInitials(String newInitials) {
        initials = newInitials;
    }

}
