package com.theinsideshine.springcloud.msvc.sections.services;


import com.theinsideshine.springcloud.msvc.sections.models.entity.Portfolio;
import com.theinsideshine.springcloud.msvc.sections.repositories.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Portfolio> list() {
        return (List<Portfolio>) portfolioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Portfolio> findById(Long id) {
        return portfolioRepository.findById(id);
    }

    @Override
    @Transactional
    public Portfolio save(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        portfolioRepository.deleteById(id);
    }
}
