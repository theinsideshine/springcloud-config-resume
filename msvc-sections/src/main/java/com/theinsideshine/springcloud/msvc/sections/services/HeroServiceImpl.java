package com.theinsideshine.springcloud.msvc.sections.services;

import com.theinsideshine.springcloud.msvc.sections.clients.UserClientRest;
import com.theinsideshine.springcloud.msvc.sections.models.User;
import com.theinsideshine.springcloud.msvc.sections.models.entity.Hero;
import com.theinsideshine.springcloud.msvc.sections.models.entity.HeroUser;
import com.theinsideshine.springcloud.msvc.sections.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private UserClientRest client;
    @Override
    @Transactional(readOnly = true)
    public List<Hero> list() {
        return (List<Hero>) heroRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Hero> findById(Long id) {
        return heroRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Hero> findByIdWithUser(Long id) {
        Optional<Hero> o = heroRepository.findById(id);
        if (o.isPresent()) {
            Hero hero = o.get();
            if (!hero.getHeroUsers().isEmpty()) {
                List<Long> ids = hero.getHeroUsers().stream().map(cu -> cu.getUserId())
                        .collect(Collectors.toList());

                List<User> users = client.getUsersPerHero(ids);
                hero.setUsers(users);
            }
            return Optional.of(hero);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        heroRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<User> assignUser(User user, Long heroId) {
        Optional<Hero> o = heroRepository.findById(heroId);
        if (o.isPresent()) {
            User userMsvc = client.detail(user.getId());

            Hero hero = o.get();
            HeroUser heroUser = new HeroUser();
            heroUser.setUserId(userMsvc.getId());

            hero.addHeroUser(heroUser);
            heroRepository.save(hero);
            return Optional.of(userMsvc);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> createUser(User user, Long heroId) {
        Optional<Hero> o = heroRepository.findById(heroId);
        if (o.isPresent()) {
            User userNewMsvc = client.create(user);

            Hero hero = o.get();
            HeroUser heroUser = new HeroUser();
            heroUser.setUserId(userNewMsvc.getId());

            hero.addHeroUser(heroUser);
            heroRepository.save(hero);
            return Optional.of(userNewMsvc);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> deleteUser(User user, Long heroId) {
        Optional<Hero> o = heroRepository.findById(heroId);
        if (o.isPresent()) {
            User userMsvc = client.detail(user.getId());

            Hero hero = o.get();
            HeroUser heroUser = new HeroUser();
            heroUser.setUserId(userMsvc.getId());

            hero.removeHeroUser(heroUser);
            heroRepository.save(hero);
            return Optional.of(userMsvc);
        }

        return Optional.empty();
    }
}
