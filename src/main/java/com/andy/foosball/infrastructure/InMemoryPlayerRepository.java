package com.andy.foosball.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import com.andy.foosball.application.exceptions.PlayerNotFoundException;
import com.andy.foosball.domain.Player;
import com.andy.foosball.domain.PlayerRepository;

/**
 * Inspired by: https://dev.to/yasmine_ddec94f4d4/onion-architecture-in-domain-driven-design-ddd-35gn
 */
public class InMemoryPlayerRepository implements PlayerRepository {
    private List<Player> players = new ArrayList<>();

    @Override
    public Player save(Player player) {
        players.add(player);
        return player;
    }

    @Override
    public Optional<Player> findByName(String name) {
        return players.stream()
            .filter(player -> name.equals(player.getName()))
            .findAny();
    }

    @Override
    public Optional<Player> findByInitials(String initials) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByInitials'");
    }

    @Override
    public void delete(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Player> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
