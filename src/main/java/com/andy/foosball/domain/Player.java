package com.andy.foosball.domain;

public class Player {

    private String name;
    private String initials;
    private int handicap = 10;

    public void setName(String newName) {
        name = newName;
    }

    public void setInitials(String newInitials) {
        initials = newInitials;
    }

}
