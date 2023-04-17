package com.theinsideshine.springcloud.msvc.sections.repositories;

import com.theinsideshine.springcloud.msvc.sections.models.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository <Contact, Long> {
}
