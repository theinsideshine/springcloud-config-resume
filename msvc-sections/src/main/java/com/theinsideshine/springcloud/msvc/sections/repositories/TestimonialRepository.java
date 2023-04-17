package com.theinsideshine.springcloud.msvc.sections.repositories;

import com.theinsideshine.springcloud.msvc.sections.models.entity.Testimonial;
import org.springframework.data.repository.CrudRepository;

public interface TestimonialRepository extends CrudRepository <Testimonial, Long> {
}
