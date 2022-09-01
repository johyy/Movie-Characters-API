package com.example.java_assignment_3.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterId;
    @Column(length = 50, nullable = false)
    private String characterName;
    @Column(length = 50)
    private String characterAlias;
    @Column(length = 10)
    private String characterGender;
    @Column(length = 100)
    private String characterPicture;
    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

}
