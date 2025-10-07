package com.andy.foosball.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

/**
 * Der blev ikke specificeret en primary key, men jeg synes at `name` er 
 * en passende primary key, da den bruges til at søge efter spillere.
 * En anden overvejelse jeg har lavet er at erklære en dedikeret `id`
 * feltvariabel af typen `UUID`. 
 * Dog er det ikke en del af business rules, så jeg er usikker på hvorvidt
 * det er en gyldig løsning.
 */
@Entity
public class Player {

    private @Id String name;
    private @Column String initials;
    private @Column int handicap = 10;

    public Player(){}

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

    public String getName() {
        return name;
    }

    public String getInitials() {
        return initials;
    }

    public int getHandicap() {
        return handicap;
    }

}
