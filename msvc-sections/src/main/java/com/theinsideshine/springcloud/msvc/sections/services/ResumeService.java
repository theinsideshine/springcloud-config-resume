package com.theinsideshine.springcloud.msvc.sections.services;

import com.theinsideshine.springcloud.msvc.sections.models.User;

import com.theinsideshine.springcloud.msvc.sections.models.entity.Resume;

import java.util.List;
import java.util.Optional;

public interface ResumeService {

    List<Resume> list();
    Optional<Resume> findById(Long id);

    Optional<Resume> findByIdWithUser(Long id);
    Resume save(Resume resume);
    void delete(Long id);

    Optional<User> assignUser(User user, Long resumeId);
    Optional<User> createUser(User user, Long resumeId);
    Optional<User> deleteUser(User user, Long resumeId);
}
