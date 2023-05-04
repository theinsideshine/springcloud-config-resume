package com.theinsideshine.springcloud.msvc.users;

import com.theinsideshine.springcloud.msvc.users.models.User;
import com.theinsideshine.springcloud.msvc.users.repositories.UserRepository;
import com.theinsideshine.springcloud.msvc.users.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class MsvcUsersApplicationTests {


    @MockBean
    UserRepository userRepository;



    @Autowired
    UserService service;


    @Test
    void testServiceFindAll() {


        when(userRepository.findAll()).thenReturn(Datas.crearListUser());

        List<User> users = service.findAll();
        assertEquals("javier.fernandez@gmail.com", users.get(0).getEmail());
        assertEquals("jimena.fernandez@gmail.com", users.get(1).getEmail());
        assertEquals("joe.fernandez@gmail.com", users.get(2).getEmail());

        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testServiceFindById() {

        when(userRepository.findById(1L)).thenReturn(Datas.crearUser001());

        Optional<User> user = service.findById(1L);
        assertEquals("Pepe.fernandez@gmail.com", user.get().getEmail());

        verify(userRepository, times(1)).findById(1L);
    }


    @Test
    void testServiceSave() {

        User user = new User();
        when(userRepository.save(user)).thenReturn(Datas.crearUser003());

        User user2 = service.save(user);
        assertEquals("Blanca.fernandez@gmail.com", user2.getEmail());

        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testServiceListByIds() {

        List<Long>ids= new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);


        when(userRepository.findAllById(ids)).thenReturn(Datas.crearListUser());

        List<User> users = service.listByIds(ids);
        assertEquals("javier.fernandez@gmail.com", users.get(0).getEmail());
        assertEquals("jimena.fernandez@gmail.com", users.get(1).getEmail());
        assertEquals("joe.fernandez@gmail.com", users.get(2).getEmail());

        verify(userRepository, times(1)).findAllById(ids);
    }

    @Test
    void testServiceFindByEmail() {

        when(userRepository.findByEmail("Pepa.fernandez@gmail.com")).thenReturn(Datas.crearUser002());

        Optional<User> user = service.findByEmail("Pepa.fernandez@gmail.com");
        assertEquals("Pepa", user.get().getName());

        verify(userRepository, times(1)).findByEmail("Pepa.fernandez@gmail.com");
    }

    @Test
    void testServiceExistByEmail() {

        when(userRepository.existsByEmail("Pepa.fernandez@gmail.com")).thenReturn(true);

        boolean exist = service.existByEmail("Pepa.fernandez@gmail.com");
        assertTrue(exist);

        verify(userRepository, times(1)).existsByEmail("Pepa.fernandez@gmail.com");
    }

}



