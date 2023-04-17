package com.theinsideshine.springcloud.msvc.sections.repositories;

import com.theinsideshine.springcloud.msvc.sections.models.entity.About;
import org.springframework.data.repository.CrudRepository;

public interface AboutRepository extends CrudRepository<About, Long> {
}
