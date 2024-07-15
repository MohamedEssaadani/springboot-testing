package org.essaadani.springboottesting.controller;

import lombok.RequiredArgsConstructor;
import org.essaadani.springboottesting.entity.Player;
import org.essaadani.springboottesting.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerRESTAPI {
    private final PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.savePlayer(player);

        return ResponseEntity.ok(savedPlayer);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAll() {
        List<Player> players = playerService.findAll();

        return ResponseEntity.ok(players);
    }
}
