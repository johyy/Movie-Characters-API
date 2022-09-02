package com.example.java_assignment_3.services.franchise;

import com.example.java_assignment_3.models.Character;
import com.example.java_assignment_3.models.Franchise;
import com.example.java_assignment_3.repositories.FranchiseRepository;
import com.example.java_assignment_3.services.character.CharacterService;
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
    public Franchise findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Franchise> findAll() {
        return null;
    }

    @Override
    public Franchise add(Franchise entity) {
        return null;
    }

    @Override
    public Franchise update(Franchise entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}