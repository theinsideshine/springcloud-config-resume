package com.theinsideshine.springcloud.msvc.users.controllers;


import com.theinsideshine.springcloud.msvc.users.Datas;
import com.theinsideshine.springcloud.msvc.users.models.User;
import com.theinsideshine.springcloud.msvc.users.repositories.UserRepository;
import com.theinsideshine.springcloud.msvc.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }


    @Test
    void testlist() throws Exception {
        // Given
        when(userService.findAll()).thenReturn((List<User>) Datas.crearListUser());

        // When
        mvc.perform(get("/").contentType(MediaType.APPLICATION_JSON))
                // Then

                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("javier"))
                .andExpect(jsonPath("$[0].email").value("javier.fernandez@gmail.com"))
                .andExpect(jsonPath("$[1].name").value("jimena"))
                .andExpect(jsonPath("$[1].email").value("jimena.fernandez@gmail.com"))
                .andExpect(jsonPath("$[2].name").value("joe"))
                .andExpect(jsonPath("$[2].email").value("joe.fernandez@gmail.com"));

        verify(userService).findAll();
    }

    @Test
    void testDetail() throws Exception {
        // Given
        when(userService.findById(1L)).thenReturn(Datas.crearUser001());

        // When
        mvc.perform(get("/1").contentType(MediaType.APPLICATION_JSON))
                // Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Pepe"))
                .andExpect(jsonPath("$.email").value("Pepe.fernandez@gmail.com"));

        verify(userService).findById(1L);
    }

    @Test
    void testCreate() throws Exception, JsonProcessingException {

        // Given
        when(userService.existByEmail("Blanca.fernandez@gmail.com")).thenReturn(false);

        User userDto = Datas.crearUser003();

        when(userService.save(userDto)).thenReturn(Datas.crearUser003());

        // When
        mvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                // Then
                .andExpect(status().isCreated());

    }

    @Test
    void testEdit() throws Exception, JsonProcessingException {

        // Given
        when(userService.findById(1L)).thenReturn(Datas.crearUser001());
        when(userService.findByEmail("Pepe.fernandez@gmail.com")).thenReturn(Datas.crearUser001());

        User userDto = Datas.crearUser001().orElseThrow();

        when(userService.save(userDto)).thenReturn(Datas.crearUser003());

        // When
        mvc.perform(put("/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                // Then
                .andExpect(status().isCreated());

    }

    @Test
    void testDelete() throws Exception, JsonProcessingException {

        // Given
        when(userService.findById(1L)).thenReturn(Datas.crearUser001());

        // When
        mvc.perform(delete("/1")
                        .contentType(MediaType.APPLICATION_JSON))
                // Then
                .andExpect(status().isNoContent());

    }


}
