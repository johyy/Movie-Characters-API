package com.example.java_assignment_3.repositories;

import com.example.java_assignment_3.models.Character;
import com.example.java_assignment_3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    @Query(value = "SELECT * FROM Character INNER JOIN movie_character ON movie_character.character_id = id WHERE movie_character.movie_id= ?1", nativeQuery = true)
    Collection<Character> findAllCharactersByMovieId(int id);

    @Query(value = "SELECT * FROM Character INNER JOIN movie_character ON movie_character.character_id = id INNER JOIN movie ON movie.id = movie_character.movie_id WHERE movie.franchise_id = ?1", nativeQuery = true)
    Collection<Character> findAllCharactersByFranchiseId(int id);
}
