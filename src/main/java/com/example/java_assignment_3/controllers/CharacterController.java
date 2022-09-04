package com.example.java_assignment_3.controllers;

import com.example.java_assignment_3.mappers.CharacterMapper;
import com.example.java_assignment_3.models.Character;
import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.models.dtos.character.CharacterDTO;
import com.example.java_assignment_3.models.dtos.movie.MovieDTO;
import com.example.java_assignment_3.services.character.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path="api/v1/characters")
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @GetMapping
    public ResponseEntity findAll() {
        Collection<CharacterDTO> characters = characterMapper.characterToCharacterDto(characterService.findAll());
        return ResponseEntity.ok(characters);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        CharacterDTO character = characterMapper.characterToCharacterDto(characterService.findById(id));
        return  ResponseEntity.ok(character);
    }

    @GetMapping("movie/{id}")
    public ResponseEntity<Collection<Character>> findAllCharactersByMovieId(@PathVariable int id) {
        return ResponseEntity.ok(characterService.findAllCharactersByMovieId(id));
    }

    @GetMapping("franchise/{id}")
    public ResponseEntity<Collection<Character>> findAllCharactersByFranchiseId(@PathVariable int id) {
        return ResponseEntity.ok(characterService.findAllCharactersByFranchiseId(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Character character) {
        Character c = characterService.add(character);
        URI location = URI.create("characters/" + c.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody CharacterDTO characterDTO, @PathVariable int id) {
        if (id != characterDTO.getId())
            return ResponseEntity.badRequest().build();
        characterService.update(characterMapper.characterDtoToCharacter(characterDTO));
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
