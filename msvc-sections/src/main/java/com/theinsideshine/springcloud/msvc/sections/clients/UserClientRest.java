package com.theinsideshine.springcloud.msvc.sections.clients;


import com.theinsideshine.springcloud.msvc.sections.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="msvc-users", url="localhost:8001")
public interface UserClientRest {

    @GetMapping("/{id}")
    User detail(@PathVariable Long id);

    @PostMapping("/")
    User create(@RequestBody User user);

    @GetMapping("/users-by-hero")
    List<User> getStudentsPerHero(@RequestParam Iterable<Long> ids);
}
