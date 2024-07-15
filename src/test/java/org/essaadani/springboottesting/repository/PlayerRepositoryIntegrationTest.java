package org.essaadani.springboottesting.repository;

import org.essaadani.springboottesting.entity.Player;
import org.essaadani.springboottesting.enums.PlayerPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@DataJpaTest
// do not replace the testcontainer data source
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlayerRepositoryIntegrationTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @Autowired
    PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        Player cr7 = new Player(null, "Cristiano", "RONALDO", PlayerPosition.ST);
        Player kroos = new Player(null, "Toni", "KROOS", PlayerPosition.LM);
        Player modric = new Player(null, "Luka", "MODRIC", PlayerPosition.RM);

        playerRepository.saveAll(List.of(kroos, modric, cr7));
    }

    @Test
    void shouldReturnCristiano() {
        Player cr7Found = playerRepository.findByLastName("RONALDO");

        assertThat(cr7Found).isNotNull();
        assertThat(cr7Found.getFirstName()).isEqualTo("Cristiano");
        assertThat(cr7Found.getPosition().name()).isEqualTo(PlayerPosition.ST.name());
    }

    @Test
    void shouldSaveAndReturnPlayer(){
        // given
        Player bellingham = new Player(null, "Jude", "BELLINGHAM", PlayerPosition.CAM);

        // when
        Player savedBellingham = playerRepository.save(bellingham);

        // then
        assertThat(savedBellingham).isNotNull();
        assertThat(savedBellingham.getLastName()).isEqualTo("BELLINGHAM");
    }
}
