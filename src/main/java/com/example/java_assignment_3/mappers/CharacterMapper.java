package com.example.java_assignment_3.mappers;

import com.example.java_assignment_3.models.Character;
import com.example.java_assignment_3.models.Franchise;
import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.models.dtos.character.CharacterDTO;
import com.example.java_assignment_3.models.dtos.franchise.FranchiseDTO;
import com.example.java_assignment_3.services.movie.MovieService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class CharacterMapper {

    @Autowired
    protected MovieService movieService;

    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract CharacterDTO characterToCharacterDto(Character character);
    public abstract Collection<CharacterDTO> characterToCharacterDto(Collection<Character> characters);

    // Mapping the other way
    @Mapping(target = "movies", source = "movies", qualifiedByName = "movieIdsToMovies")
    public abstract Character characterDtoToCharacter(CharacterDTO characterDTO);

    @Named("moviesToIds")
    Set<Integer> mapMoviesToIds(Set<Movie> source) {
        if(source == null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }

    @Named("movieIdsToMovies")
    Set<Movie> mapIdsToMovies(Set<Integer> id) {
        return id.stream()
                .map( i -> movieService.findById(i))
                .collect(Collectors.toSet());
    }
}
