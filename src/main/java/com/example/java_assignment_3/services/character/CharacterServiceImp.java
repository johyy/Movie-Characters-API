package com.example.java_assignment_3.services.character;

import com.example.java_assignment_3.models.Character;
import com.example.java_assignment_3.repositories.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CharacterServiceImp implements CharacterService{

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImp.class);
    private final CharacterRepository characterRepository;

    public CharacterServiceImp(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Character> findAll() {
        return null;
    }

    @Override
    public Character add(Character entity) {
        return null;
    }

    @Override
    public Character update(Character entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

}
