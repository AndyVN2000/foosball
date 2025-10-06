package com.andy.foosball.domain;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {

    Player save(Player player);

    Optional<Player> findByName(String name);

    Optional<Player> findByInitials(String initials);

    void delete(Player player);

    List<Player> findAll();

}
