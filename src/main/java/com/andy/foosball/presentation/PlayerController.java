package com.andy.foosball.presentation;

import com.andy.foosball.application.PlayerApplicationService;
import com.andy.foosball.domain.PlayerRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * https://spring.io/guides/tutorials/rest
 */
@RestController
public class PlayerController {
    PlayerRepository playerRepository;
    PlayerApplicationService playerApplicationService;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerApplicationService = new PlayerApplicationService(playerRepository);
    }



}
