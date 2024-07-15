package org.essaadani.springboottesting.repository;


import org.essaadani.springboottesting.entity.Player;
import org.essaadani.springboottesting.enums.PlayerPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class PlayerRepositoryUnitTest {
    @Mock
    private PlayerRepository playerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnOnePlayer() {
        Player playerToFind = new Player(null, "Eden", "HAZARD", PlayerPosition.LW);

        // given
        when(playerRepository.findById(1L)).thenReturn(Optional.of(playerToFind));

        // when
        Player foundPlayer = playerRepository.findById(1L).orElse(null);

        // then
        assertThat(foundPlayer).isNotNull();
        assertThat(foundPlayer.getFirstName()).isEqualTo("Eden");
        assertThat(foundPlayer.getLastName()).isEqualTo("HAZARD");
    }
}
