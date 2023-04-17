package com.theinsideshine.springcloud.msvc.sections.services;



import com.theinsideshine.springcloud.msvc.sections.models.entity.Testimonial;

import java.util.List;
import java.util.Optional;

public interface TestimonialService {
    List<Testimonial> list();
    Optional<Testimonial> findById(Long id);


    Testimonial save(Testimonial testimonial);
    void delete(Long id);


}
