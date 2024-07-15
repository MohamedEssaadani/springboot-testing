package org.essaadani.springboottesting.service;

import org.essaadani.springboottesting.entity.Player;
import org.essaadani.springboottesting.enums.PlayerPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
class PlayerServiceImplIntegrationTest {
    @Autowired
    PlayerServiceImpl playerService;

    @Container
    @ServiceConnection
    private static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16-alpine");

    @BeforeEach
    void setUp() {
        playerService.deleteAll();
        Player kane = new Player(null, "Harry", "KANE", PlayerPosition.ST);
        playerService.savePlayer(kane);
    }

    @Test
    void savePlayer() {
        // Given
        Player hazard = new Player(null, "Eden", "HAZARD", PlayerPosition.LW);

        // When
        Player savedPlayer = playerService.savePlayer(hazard);

        // Then
        Player foundPlayer = playerService.findPlayerById(savedPlayer.getId());
        assertThat(foundPlayer).isNotNull();
        assertThat(foundPlayer.getFirstName()).isEqualTo("Eden");
        assertThat(foundPlayer.getLastName()).isEqualTo("HAZARD");
    }


    @Test
    void findPlayerByLastName() {
        Player foundKane = playerService.findPlayerByLastName("KANE");

        assertThat(foundKane).isNotNull();
        assertThat(foundKane.getFirstName()).isEqualTo("Harry");
        assertThat(foundKane.getLastName()).isEqualTo("KANE");

    }
}
