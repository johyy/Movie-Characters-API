package com.example.java_assignment_3.mappers;

import com.example.java_assignment_3.models.Character;
import com.example.java_assignment_3.models.Franchise;
import com.example.java_assignment_3.models.dtos.character.CharacterDTO;
import com.example.java_assignment_3.models.dtos.franchise.FranchiseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterDTO characterToCharacterDto(Character character);
    Collection<CharacterDTO> characterToCharacterDto(Collection<Character> characters);

    // Mapping the other way
    @Mapping(target = "movies", ignore = true)
    Character characterDtoToCharacter(CharacterDTO characterDTO);
}
