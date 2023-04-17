package com.theinsideshine.springcloud.msvc.sections.services;

import com.theinsideshine.springcloud.msvc.sections.models.entity.Hero;
import com.theinsideshine.springcloud.msvc.sections.models.User;

import java.util.List;
import java.util.Optional;

public interface HeroService {
    List<Hero> list();
    Optional<Hero> findById(Long id);

    Optional<Hero> findByIdWithUser(Long id);
    Hero save(Hero hero);
    void delete(Long id);

    Optional<User> assignUser(User user, Long heroId);
    Optional<User> createUser(User user, Long heroId);
    Optional<User> deleteUser(User user, Long heroId);
}
