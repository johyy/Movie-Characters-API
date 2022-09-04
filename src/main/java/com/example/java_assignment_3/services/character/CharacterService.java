package com.example.java_assignment_3.services.character;

import com.example.java_assignment_3.models.Character;
import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.services.CrudService;

import java.util.Collection;

public interface CharacterService extends CrudService<Character, Integer> {

    Collection<Character> findAllCharactersByMovieId(int id);
    Collection<Character> findAllCharactersByFranchiseId(int id);
}
