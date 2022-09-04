package com.example.java_assignment_3.models.dtos.character;

import lombok.Data;

import java.util.Set;

@Data
public class CharacterDTO {

    private int id;
    private String characterName;
    private String characterAlias;
    private String characterGender;
    private String characterPicture;
    //private Set<Integer> movies;

}
