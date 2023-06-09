package com.theinsideshine.springcloud.msvc.sections.clients;


import com.theinsideshine.springcloud.msvc.sections.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name="msvc-users", url="localhost:8001")
@FeignClient(name="msvc-users", url="${msvc.users.url}")
public interface UserClientRest {

    @GetMapping("/{id}")
    User detail(@PathVariable Long id);

    @PostMapping("/")
    User create(@RequestBody User user);

    @GetMapping("/users-by-ids")
    List<User> getUsersPerIds(@RequestParam Iterable<Long> ids);



}
