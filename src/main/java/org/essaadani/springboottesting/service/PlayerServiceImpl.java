package org.essaadani.springboottesting.service;

import org.essaadani.springboottesting.entity.Player;
import org.essaadani.springboottesting.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player findPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow();
    }

    @Override
    public Player findPlayerByLastName(String lastName) {
        return playerRepository.findByLastName(lastName);
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        playerRepository.deleteAll();
    }
}
