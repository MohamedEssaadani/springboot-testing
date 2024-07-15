package org.essaadani.springboottesting.controller;

import org.essaadani.springboottesting.service.PlayerService;
import org.essaadani.springboottesting.service.PlayerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// setup env test for PlayerRestAPI with related components
@WebMvcTest(PlayerRESTAPI.class)
class PlayerRESTAPIUnitTest {
    @MockBean
    PlayerService playerService;

    @InjectMocks
    PlayerRESTAPI playerRESTAPI;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void savePlayer() throws Exception {

        mockMvc.perform(
                        post("/api/players")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"firstName\":\"Eden\", \"lastName\":\"HAZARD\", \"position\":\"RW\"}")
                )
                .andExpect(status().isOk());
    }

    @Test
    void getAll() {
    }
}
