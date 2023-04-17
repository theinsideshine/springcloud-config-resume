package com.theinsideshine.springcloud.msvc.sections.services;



import com.theinsideshine.springcloud.msvc.sections.models.entity.Testimonial;
import com.theinsideshine.springcloud.msvc.sections.repositories.TestimonialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Testimonial> list() {
        return (List<Testimonial>) testimonialRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Testimonial> findById(Long id) {
        return testimonialRepository.findById(id);
    }

    @Override
    @Transactional
    public Testimonial save(Testimonial testimonial) {
        return testimonialRepository.save(testimonial);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        testimonialRepository.deleteById(id);
    }
}
