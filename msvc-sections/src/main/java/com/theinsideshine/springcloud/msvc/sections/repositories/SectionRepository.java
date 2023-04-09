package com.theinsideshine.springcloud.msvc.sections.repositories;

import com.theinsideshine.springcloud.msvc.sections.models.Section;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository extends CrudRepository <Section, Long> {
}
