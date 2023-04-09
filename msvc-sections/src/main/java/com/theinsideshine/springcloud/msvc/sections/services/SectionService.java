package com.theinsideshine.springcloud.msvc.sections.services;

import com.theinsideshine.springcloud.msvc.sections.models.Section;

import java.util.List;
import java.util.Optional;

public interface SectionService {
    List<Section> list();
    Optional<Section> findById(Long id);
    Section save(Section curso);
    void delete(Long id);
}
