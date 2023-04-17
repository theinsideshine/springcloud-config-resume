package com.theinsideshine.springcloud.msvc.sections.services;

import com.theinsideshine.springcloud.msvc.sections.models.User;
import com.theinsideshine.springcloud.msvc.sections.models.entity.About;
import com.theinsideshine.springcloud.msvc.sections.models.entity.Hero;

import java.util.List;
import java.util.Optional;

public interface AboutService {

    List<About> list();
    Optional<About> findById(Long id);

    Optional<About> findByIdWithUser(Long id);
    About save(About about);
    void delete(Long id);

    Optional<User> assignUser(User user, Long aboutId);
    Optional<User> createUser(User user, Long aboutId);
    Optional<User> deleteUser(User user, Long aboutId);
}
