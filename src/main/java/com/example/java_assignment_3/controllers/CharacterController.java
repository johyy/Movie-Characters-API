package com.example.java_assignment_3.controllers;

import com.example.java_assignment_3.mappers.CharacterMapper;
import com.example.java_assignment_3.models.Character;
import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.models.dtos.character.CharacterDTO;
import com.example.java_assignment_3.models.dtos.movie.MovieDTO;
import com.example.java_assignment_3.services.character.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get all characters")
    @GetMapping
    public ResponseEntity findAll() {
        Collection<CharacterDTO> characters = characterMapper.characterToCharacterDto(characterService.findAll());
        return ResponseEntity.ok(characters);
    }

    @Operation(summary = "Get a character by id")
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        CharacterDTO character = characterMapper.characterToCharacterDto(characterService.findById(id));
        return  ResponseEntity.ok(character);
    }

    @Operation(summary = "Get characters in a movie")
    @GetMapping("movie/{id}")
    public ResponseEntity<Collection<Character>> findAllCharactersByMovieId(@PathVariable int id) {
        return ResponseEntity.ok(characterService.findAllCharactersByMovieId(id));
    }

    @Operation(summary = "Get characters in a franchise")
    @GetMapping("franchise/{id}")
    public ResponseEntity<Collection<Character>> findAllCharactersByFranchiseId(@PathVariable int id) {
        return ResponseEntity.ok(characterService.findAllCharactersByFranchiseId(id));
    }

    @Operation(summary = "Adds a new character")
    @PostMapping
    public ResponseEntity add(@RequestBody Character character) {
        Character c = characterService.add(character);
        URI location = URI.create("characters/" + c.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update a character")
    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody CharacterDTO characterDTO, @PathVariable int id) {
        if (id != characterDTO.getId())
            return ResponseEntity.badRequest().build();
        characterService.update(characterMapper.characterDtoToCharacter(characterDTO));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a character")
    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        System.out.println(characterService.findById(id));
        if(characterService.findById(id) == null){
            return ResponseEntity.badRequest().build();
        }
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
