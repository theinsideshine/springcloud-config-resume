package com.theinsideshine.springcloud.msvc.sections.repositories;


import com.theinsideshine.springcloud.msvc.sections.models.entity.Portfolio;
import org.springframework.data.repository.CrudRepository;

public interface PortfolioRepository extends CrudRepository <Portfolio, Long> {
}
