package com.theinsideshine.springcloud.msvc.users.controllers;

import com.theinsideshine.springcloud.msvc.users.models.User;
import com.theinsideshine.springcloud.msvc.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody User user, @PathVariable Long id) {
        Optional<User> o = userService.findById(id);
        if (o.isPresent()) {
            User userDb = o.get();
            userDb.setName(user.getName());
            userDb.setEmail(user.getEmail());
            userDb.setLocation(user.getLocation());
            userDb.setLocationLink(user.getLocationLink());
            userDb.setNationality(user.getNationality());
            userDb.setStudy(user.getStudy());
            userDb.setAge(user.getAge());
            userDb.setInterests(user.getInterests());
            userDb.setEmployment(user.getEmployment());
            userDb.setIg(user.getIg());
            userDb.setIgLink(user.getIgLink());
            userDb.setGithub(user.getGithub());
            userDb.setGithubLink(user.getGithubLink());
            userDb.setYoutube(user.getYoutube());
            userDb.setYoutube(user.getYoutubeLink());


            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<User> o = userService.findById(id);
        if (o.isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
