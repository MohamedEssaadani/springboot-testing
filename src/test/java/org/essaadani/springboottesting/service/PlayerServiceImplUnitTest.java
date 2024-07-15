package org.essaadani.springboottesting.service;

import org.essaadani.springboottesting.entity.Player;
import org.essaadani.springboottesting.enums.PlayerPosition;
import org.essaadani.springboottesting.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PlayerServiceImplUnitTest {
    @Mock
    PlayerRepository playerRepository;

    @InjectMocks
    PlayerServiceImpl playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreatePlayer() {
        //
        Player messi = new Player(null, "Lionel", "MESSI", PlayerPosition.RW);

        //
        when(playerRepository.save(any(Player.class))).thenReturn(messi);

        Player savedPlayer = playerService.savePlayer(messi);

        //
        assertThat(savedPlayer).isNotNull();
        assertThat(savedPlayer.getLastName()).isEqualTo("MESSI");
        assertThat(savedPlayer.getFirstName()).isEqualTo("Lionel");
    }

    @Test
    void shouldFindPlayerById() {
        //
        Player mbappe = new Player(null, "Kylian", "MBAPPE", PlayerPosition.LW);

        //
        when(playerRepository.findById(1L)).thenReturn(Optional.of(mbappe));

        //
        Optional<Player> foundMbappe = playerRepository.findById(1L);
        assertThat(foundMbappe).isPresent();
        assertThat(foundMbappe.get().getLastName()).isEqualTo("MBAPPE");
        assertThat(foundMbappe.get().getFirstName()).isEqualTo("Kylian");

    }
}
