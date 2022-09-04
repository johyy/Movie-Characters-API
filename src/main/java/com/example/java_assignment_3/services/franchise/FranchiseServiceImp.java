package com.example.java_assignment_3.services.franchise;

import com.example.java_assignment_3.models.Franchise;
import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.repositories.FranchiseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FranchiseServiceImp implements FranchiseService {

    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImp.class);
    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImp(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id).get();
    }

    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @Override
    public Franchise update(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @Override
    public void deleteById(Integer id) {
        franchiseRepository.deleteById(id);
    }


}
