package com.example.java_assignment_3.mappers;

import com.example.java_assignment_3.models.Franchise;
import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.models.Character;
import com.example.java_assignment_3.models.dtos.movie.MovieDTO;
import com.example.java_assignment_3.services.character.CharacterService;
import com.example.java_assignment_3.services.franchise.FranchiseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {

    @Autowired
    protected CharacterService characterService;
    @Autowired
    protected FranchiseService franchiseService;

    @Mapping(target = "franchise", source = "franchise.id")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "charactersToIds")
    public abstract MovieDTO movieToMovieDto(Movie movie);

    public abstract Collection<MovieDTO> movieToMovieDto(Collection<Movie> movies);

    @Mapping(target = "franchise", source = "franchise", qualifiedByName = "franchiseIdToFranchise")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "characterIdsToCharacters")
    public abstract Movie movieDtoToMovie(MovieDTO dto);

    @Named("franchiseIdToFranchise")
    Franchise mapIdToFranchise(int id) {
        return franchiseService.findById(id);
    }

    @Named("characterIdsToCharacters")
    Set<Character> mapIdsToCharacters(Set<Integer> id) {
        return id.stream()
                .map( i -> characterService.findById(i))
                .collect(Collectors.toSet());
    }

    @Named("charactersToIds")
    Set<Integer> mapCharactersToIds(Set<Character> source) {
        if(source == null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }
}
