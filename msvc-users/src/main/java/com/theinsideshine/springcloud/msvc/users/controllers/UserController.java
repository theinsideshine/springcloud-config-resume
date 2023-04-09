package com.theinsideshine.springcloud.msvc.users.controllers;

import com.theinsideshine.springcloud.msvc.users.models.User;
import com.theinsideshine.springcloud.msvc.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        if (!user.getEmail().isEmpty() && userService.existByEmail(user.getEmail())) {
            return ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje", "Ya existe un usuario con ese correo electronico!"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody User user, @PathVariable Long id, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Optional<User> o = userService.findById(id);
        if (o.isPresent()) {
            User userDb = o.get();
            if (!user.getEmail().isEmpty() &&
                    !user.getEmail().equalsIgnoreCase(userDb.getEmail()) &&
                    userService.findByEmail(user.getEmail()).isPresent()) {
                return ResponseEntity.badRequest()
                        .body(Collections
                                .singletonMap("mensaje", "Ya existe un usuario con ese correo electronico!"));
            }
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

    private ResponseEntity<Map<String, String>> validate(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

}
