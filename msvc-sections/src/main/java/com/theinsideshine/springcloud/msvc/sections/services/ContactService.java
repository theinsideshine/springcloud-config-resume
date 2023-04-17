package com.theinsideshine.springcloud.msvc.sections.services;

import com.theinsideshine.springcloud.msvc.sections.models.User;
import com.theinsideshine.springcloud.msvc.sections.models.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> list();
    Optional<Contact> findById(Long id);

    Optional<Contact> findByIdWithUser(Long id);
    Contact save(Contact contact);
    void delete(Long id);

    Optional<User> assignUser(User user, Long contactId);
    Optional<User> createUser(User user, Long contactId);
    Optional<User> deleteUser(User user, Long contactId);
}
