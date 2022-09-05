package com.example.java_assignment_3.controllers;

import com.example.java_assignment_3.mappers.FranchiseMapper;
import com.example.java_assignment_3.models.Franchise;
import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.models.dtos.character.CharacterDTO;
import com.example.java_assignment_3.models.dtos.franchise.FranchiseDTO;
import com.example.java_assignment_3.models.dtos.movie.MovieDTO;
import com.example.java_assignment_3.services.franchise.FranchiseService;
import com.example.java_assignment_3.util.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.boot.web.error.ErrorAttributeOptions;
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

    @Operation(summary = "Get all franchises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = FranchiseDTO.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "Franchise does not exist with supplied ID",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity findAll() {
        Collection<FranchiseDTO> franchises = franchiseMapper.franchiseToFranchiseDto(franchiseServise.findAll());
        return ResponseEntity.ok(franchises);
    }

    @Operation(summary = "Get a franchise by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseDTO.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Franchise does not exist with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        FranchiseDTO franchise = franchiseMapper.franchiseToFranchiseDto(franchiseServise.findById(id));
        return  ResponseEntity.ok(franchise);
    }

    @Operation(summary = "Add a new franchise")
    @PostMapping
    public ResponseEntity add(@RequestBody Franchise franchise) {
        Franchise fra = franchiseServise.add(franchise);
        URI location = URI.create("franchises/" + fra.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update a franchise")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Franchise successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorAttributeOptions.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Franchise not found with supplied ID",
                    content = @Content)
    })
    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody FranchiseDTO franchiseDTO, @PathVariable int id) {
        if (id != franchiseDTO.getId())
            return ResponseEntity.badRequest().build();
        franchiseServise.update(franchiseMapper.franchiseDtoToFranchise(franchiseDTO)
        );
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a franchise")
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        franchiseServise.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}