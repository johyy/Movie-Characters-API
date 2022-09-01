package com.example.java_assignment_3.repositories;

import com.example.java_assignment_3.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    //business logic here
}
