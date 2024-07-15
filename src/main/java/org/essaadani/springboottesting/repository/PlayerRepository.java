package org.essaadani.springboottesting.repository;

import org.essaadani.springboottesting.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByLastName(String ronaldo);
}
