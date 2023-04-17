package com.theinsideshine.springcloud.msvc.sections.services;

import com.theinsideshine.springcloud.msvc.sections.clients.UserClientRest;
import com.theinsideshine.springcloud.msvc.sections.models.User;
import com.theinsideshine.springcloud.msvc.sections.models.entity.About;
import com.theinsideshine.springcloud.msvc.sections.models.entity.AboutUser;
import com.theinsideshine.springcloud.msvc.sections.repositories.AboutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AboutServiceimpl implements AboutService{

    @Autowired
    private AboutRepository aboutRepository;

    @Autowired
    private UserClientRest client;
    @Override
    @Transactional(readOnly = true)
    public List<About> list() {
        return (List<About>) aboutRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<About> findById(Long id) {
        return aboutRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<About> findByIdWithUser(Long id) {
        Optional<About> o = aboutRepository.findById(id);
        if (o.isPresent()) {
            About about = o.get();
            if (!about.getAboutUsers().isEmpty()) {
                List<Long> ids = about.getAboutUsers().stream().map(cu -> cu.getUserId())
                        .collect(Collectors.toList());

                List<User> users = client.getUsersPerIds(ids);
                about.setUsers(users);
            }
            return Optional.of(about);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public About save(About about) {
        return aboutRepository.save(about);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        aboutRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<User> assignUser(User user, Long aboutId) {
        Optional<About> o = aboutRepository.findById(aboutId);
        if (o.isPresent()) {
            User userMsvc = client.detail(user.getId());

            About about = o.get();
            AboutUser aboutUser = new AboutUser();
            aboutUser.setUserId(userMsvc.getId());

            about.addAboutUser(aboutUser);
            aboutRepository.save(about);
            return Optional.of(userMsvc);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> createUser(User user, Long aboutId) {
        Optional<About> o = aboutRepository.findById(aboutId);
        if (o.isPresent()) {
            User userNewMsvc = client.create(user);

            About about = o.get();
            AboutUser aboutUser = new AboutUser();
            aboutUser.setUserId(userNewMsvc.getId());

            about.addAboutUser(aboutUser);
            aboutRepository.save(about);
            return Optional.of(userNewMsvc);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> deleteUser(User user, Long aboutId) {
        Optional<About> o = aboutRepository.findById(aboutId);
        if (o.isPresent()) {
            User userMsvc = client.detail(user.getId());

            About about = o.get();
            AboutUser aboutUser = new AboutUser();
            aboutUser.setUserId(userMsvc.getId());

            about.removeAboutUser(aboutUser);
            aboutRepository.save(about);
            return Optional.of(userMsvc);
        }

        return Optional.empty();
    }
}
