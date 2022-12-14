package com.example.java_assignment_3.services.character;

import com.example.java_assignment_3.exceptions.CharacterNotFoundException;
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
    public Character findById(Integer id) {
        return characterRepository.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
    }

    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public Character update(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public void deleteById(Integer id) {
        Character character = characterRepository.findById(id).get();
        character.removeCharacterFromMovie();
        characterRepository.deleteById(id);
    }

    @Override
    public Collection<Character> findAllCharactersByMovieId(int id) {
        return characterRepository.findAllCharactersByMovieId(id);
    }

    @Override
    public Collection<Character> findAllCharactersByFranchiseId(int id) {
        return characterRepository.findAllCharactersByMovieId(id);
    }
}
