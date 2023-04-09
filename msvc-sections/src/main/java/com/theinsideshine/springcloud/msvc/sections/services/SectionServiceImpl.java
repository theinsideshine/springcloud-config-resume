package com.theinsideshine.springcloud.msvc.sections.services;

import com.theinsideshine.springcloud.msvc.sections.models.Section;
import com.theinsideshine.springcloud.msvc.sections.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImpl implements  SectionService{

    @Autowired
    private SectionRepository sectionRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Section> list() {
        return (List<Section>) sectionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Section> findById(Long id) {
        return sectionRepository.findById(id);
    }

    @Override
    @Transactional
    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        sectionRepository.deleteById(id);

    }
}
