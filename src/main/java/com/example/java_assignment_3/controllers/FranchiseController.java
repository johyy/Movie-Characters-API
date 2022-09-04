package com.example.java_assignment_3.controllers;

import com.example.java_assignment_3.mappers.FranchiseMapper;
import com.example.java_assignment_3.models.Franchise;
import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.models.dtos.franchise.FranchiseDTO;
import com.example.java_assignment_3.models.dtos.movie.MovieDTO;
import com.example.java_assignment_3.services.franchise.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path="api/v1/franchises")
public class FranchiseController {

    private final FranchiseService franchiseServise;
    private final FranchiseMapper franchiseMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseServise = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }

    @GetMapping
    public ResponseEntity findAll() {
        Collection<FranchiseDTO> franchises = franchiseMapper.franchiseToFranchiseDto(franchiseServise.findAll());
        return ResponseEntity.ok(franchises);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        FranchiseDTO franchise = franchiseMapper.franchiseToFranchiseDto(franchiseServise.findById(id));
        return  ResponseEntity.ok(franchise);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Franchise franchise) {
        Franchise fra = franchiseServise.add(franchise);
        URI location = URI.create("franchises/" + fra.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody FranchiseDTO franchiseDTO, @PathVariable int id) {
        if (id != franchiseDTO.getId())
            return ResponseEntity.badRequest().build();
        franchiseServise.update(franchiseMapper.franchiseDtoToFranchise(franchiseDTO)
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        franchiseServise.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}