package com.theinsideshine.springcloud.msvc.sections.repositories;

import com.theinsideshine.springcloud.msvc.sections.models.entity.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository <Hero, Long> {
}
