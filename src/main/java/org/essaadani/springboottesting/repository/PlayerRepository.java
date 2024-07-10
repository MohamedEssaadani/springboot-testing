package org.essaadani.springboottesting.repository;

import org.essaadani.springboottesting.entity.Player;
import org.springframework.data.repository.ListCrudRepository;

public interface PlayerRepository extends ListCrudRepository<Player, Long> {
}
