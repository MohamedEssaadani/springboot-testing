package org.essaadani.springboottesting.service;

import org.essaadani.springboottesting.entity.Player;

public interface PlayerService {
    Player savePlayer(Player player);

    Player findPlayerById(Long id);

    Player findPlayerByLastName(String lastName);

    void deletePlayer(Long id);

    void deleteAll();
}
