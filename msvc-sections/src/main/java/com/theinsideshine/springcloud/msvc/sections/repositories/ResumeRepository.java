package com.theinsideshine.springcloud.msvc.sections.repositories;


import com.theinsideshine.springcloud.msvc.sections.models.entity.Resume;
import org.springframework.data.repository.CrudRepository;

public interface ResumeRepository extends CrudRepository <Resume, Long> {
}
