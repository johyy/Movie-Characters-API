package com.example.java_assignment_3.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String characterName;
    @Column(length = 50)
    private String characterAlias;
    @Column(length = 10)
    private String characterGender;
    @Column(length = 100)
    private String characterPicture;
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;

    public int getId() {
        return id;
    }
}
