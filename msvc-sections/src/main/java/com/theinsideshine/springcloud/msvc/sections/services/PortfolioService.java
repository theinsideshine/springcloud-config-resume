package com.theinsideshine.springcloud.msvc.sections.services;


import com.theinsideshine.springcloud.msvc.sections.models.entity.Portfolio;

import java.util.List;
import java.util.Optional;

public interface PortfolioService {
    List<Portfolio> list();
    Optional<Portfolio> findById(Long id);


    Portfolio save(Portfolio portfolio);
    void delete(Long id);


}
