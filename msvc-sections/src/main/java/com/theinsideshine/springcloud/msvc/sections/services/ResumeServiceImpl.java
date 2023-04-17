package com.theinsideshine.springcloud.msvc.sections.services;

import com.theinsideshine.springcloud.msvc.sections.clients.UserClientRest;
import com.theinsideshine.springcloud.msvc.sections.models.User;
import com.theinsideshine.springcloud.msvc.sections.models.entity.Resume;

import com.theinsideshine.springcloud.msvc.sections.models.entity.ResumeUser;
import com.theinsideshine.springcloud.msvc.sections.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private UserClientRest client;
    @Override
    @Transactional(readOnly = true)
    public List<Resume> list() {
        return (List<Resume>) resumeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Resume> findById(Long id) {
        return resumeRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Resume> findByIdWithUser(Long id) {
        Optional<Resume> o = resumeRepository.findById(id);
        if (o.isPresent()) {
            Resume resume = o.get();
            if (!resume.getResumeUsers().isEmpty()) {
                List<Long> ids = resume.getResumeUsers().stream().map(cu -> cu.getUserId())
                        .collect(Collectors.toList());

                List<User> users = client.getUsersPerHero(ids);
                resume.setUsers(users);
            }
            return Optional.of(resume);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Resume save(Resume resume) {
        return resumeRepository.save(resume);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        resumeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<User> assignUser(User user, Long resumeId) {
        Optional<Resume> o = resumeRepository.findById(resumeId);
        if (o.isPresent()) {
            User userMsvc = client.detail(user.getId());

            Resume resume = o.get();
            ResumeUser resumeUser = new ResumeUser();
            resumeUser.setUserId(userMsvc.getId());

            resume.addResumeUser(resumeUser);
            resumeRepository.save(resume);
            return Optional.of(userMsvc);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> createUser(User user, Long resumeId) {
        Optional<Resume> o = resumeRepository.findById(resumeId);
        if (o.isPresent()) {
            User userNewMsvc = client.create(user);

            Resume resume= o.get();
            ResumeUser resumeUser = new ResumeUser();
            resumeUser.setUserId(userNewMsvc.getId());

            resume.addResumeUser(resumeUser);
            resumeRepository.save(resume);
            return Optional.of(userNewMsvc);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> deleteUser(User user, Long resumeId) {
        Optional<Resume> o = resumeRepository.findById(resumeId);
        if (o.isPresent()) {
            User userMsvc = client.detail(user.getId());

            Resume resume = o.get();
            ResumeUser resumeUser = new ResumeUser();
            resumeUser.setUserId(userMsvc.getId());

            resume.removeResumeUser(resumeUser);
            resumeRepository.save(resume);
            return Optional.of(userMsvc);
        }

        return Optional.empty();
    }
}
