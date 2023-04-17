package com.theinsideshine.springcloud.msvc.sections.services;

import com.theinsideshine.springcloud.msvc.sections.clients.UserClientRest;
import com.theinsideshine.springcloud.msvc.sections.models.User;
import com.theinsideshine.springcloud.msvc.sections.models.entity.Contact;
import com.theinsideshine.springcloud.msvc.sections.models.entity.ContactUser;
import com.theinsideshine.springcloud.msvc.sections.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserClientRest client;
    @Override
    @Transactional(readOnly = true)
    public List<Contact> list() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> findByIdWithUser(Long id) {
        Optional<Contact> o = contactRepository.findById(id);
        if (o.isPresent()) {
            Contact contact = o.get();
            if (!contact.getContactUsers().isEmpty()) {
                List<Long> ids = contact.getContactUsers().stream().map(cu -> cu.getUserId())
                        .collect(Collectors.toList());

                List<User> users = client.getUsersPerIds(ids);
                contact.setUsers(users);
            }
            return Optional.of(contact);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<User> assignUser(User user, Long contactId) {
        Optional<Contact> o = contactRepository.findById(contactId);
        if (o.isPresent()) {
            User userMsvc = client.detail(user.getId());

            Contact contact = o.get();
            ContactUser contactUser = new ContactUser();
            contactUser.setUserId(userMsvc.getId());

            contact.addContactUser(contactUser);
            contactRepository.save(contact);
            return Optional.of(userMsvc);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> createUser(User user, Long contactId) {
        Optional<Contact> o = contactRepository.findById(contactId);
        if (o.isPresent()) {
            User userNewMsvc = client.create(user);

            Contact contact = o.get();
            ContactUser contactUser = new ContactUser();
            contactUser.setUserId(userNewMsvc.getId());

            contact.addContactUser(contactUser);
            contactRepository.save(contact);
            return Optional.of(userNewMsvc);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> deleteUser(User user, Long contactId) {
        Optional<Contact> o = contactRepository.findById(contactId);
        if (o.isPresent()) {
            User userMsvc = client.detail(user.getId());

            Contact contact = o.get();
            ContactUser contactUser = new ContactUser();
            contactUser.setUserId(userMsvc.getId());

            contact.removeContactUser(contactUser);
            contactRepository.save(contact);
            return Optional.of(userMsvc);
        }

        return Optional.empty();
    }
}
