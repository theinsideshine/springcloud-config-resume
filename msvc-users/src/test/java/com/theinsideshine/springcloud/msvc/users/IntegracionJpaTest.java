package com.theinsideshine.springcloud.msvc.users;



import com.theinsideshine.springcloud.msvc.users.models.User;
import com.theinsideshine.springcloud.msvc.users.repositories.UserRepository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class IntegracionJpaTest {
    @Autowired
    UserRepository userRepository;


    @Test
    @Order(1)
    void testFindAll() {
        List<User> users = (List<User>) userRepository.findAll();
        assertFalse(users.isEmpty());
        assertEquals(2, users.size());
    }
    @Test
    @Order(2)
    void testFindById() {
        Optional<User> user = userRepository.findById(1L);
        assertTrue(user.isPresent());
        assertEquals("andres", user.orElseThrow().getName());
    }

    @Test
    @Order(3)
    void testFindByEmail() {
        Optional<User> user = userRepository.findByEmail("john.fernandez@gmail.com");
        assertTrue(user.isPresent());
        assertEquals("john", user.orElseThrow().getName());
    }

    @Test
    @Order(4)
    void existsByEmail() {
        assertTrue(userRepository.existsByEmail("andres.fernandez@gmail.com"));

    }

    @Test
    @Order(5)
    void testSave() {
        // Given
        User userPepe = new User(1L, "Pepe", "Pepe.fernandez@gmail.com", "Caba", "Argentine",
                "Caballito", "https://goo.gl/maps/i4UvTVHGuZoH2X8r9", "Argentine", "Electronic Engineer",
                "Senior Electronics Technician", "Mercantile Marine University", "46", "Technology, Music",
                "CDT Soluciones Tecnologicas", "@educacion.ta", "https://www.instagram.com/educacion.ta/", "theinsideshine",
                "https://github.com/theinsideshine", "theinsideshine", "https://www.youtube.com/channel/UClLTMbxqK8LLSWm4bOdyx5Q",
                "https://linkedin.com/in/andres-fernandez", "https://www.facebook.com/andresFernandez");

        // When
        User user = userRepository.save(userPepe);

        // Then
        assertEquals("Pepe", user.getName()); assertEquals("Pepe.fernandez@gmail.com", user.getEmail());
        assertEquals("Caba", user.getCity()); assertEquals("Argentine", user.getCountry());
        assertEquals("Caballito", user.getLocation()); assertEquals("https://goo.gl/maps/i4UvTVHGuZoH2X8r9", user.getLocationLink());
        assertEquals("Argentine", user.getNationality()); assertEquals("Electronic Engineer", user.getGraduation());
        assertEquals("Senior Electronics Technician", user.getTechniqueGraduation());assertEquals("Mercantile Marine University", user.getStudy());
        assertEquals("46", user.getAge());assertEquals("Technology, Music", user.getInterests());
        assertEquals("CDT Soluciones Tecnologicas", user.getEmployment());assertEquals("@educacion.ta", user.getIg());
        assertEquals("https://www.instagram.com/educacion.ta/", user.getIgLink());assertEquals("theinsideshine", user.getGithub());
        assertEquals("https://github.com/theinsideshine", user.getGithubLink());assertEquals("theinsideshine", user.getYoutube());
        assertEquals("https://www.youtube.com/channel/UClLTMbxqK8LLSWm4bOdyx5Q", user.getYoutubeLink());assertEquals("https://linkedin.com/in/andres-fernandez", user.getLinkedinLink());
        assertEquals("https://www.facebook.com/andresFernandez", user.getFacebookLink());
    }

    @Test
    @Order(6)
    void testDelete() {
        User user = userRepository.findById(2L).orElseThrow();
        assertEquals("john", user.getName());

        userRepository.delete(user);

        assertThrows(NoSuchElementException.class, () -> {

            userRepository.findById(2L).orElseThrow();
        });
        assertEquals(1,  userRepository.findAll().spliterator().getExactSizeIfKnown());
    }


}
