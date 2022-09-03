package com.example.java_assignment_3.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String movieTitle;
    @Column(length = 50)
    private String movieGenre;
    @Column(length = 10)
    private String movieReleaseYear;
    @Column(length = 50)
    private String movieDirector;
    @Column(length = 100)
    private String moviePicture;
    @Column(length = 100)
    private String movieTrailer;
    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;
    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    public int getId() {
        return id;
    }
}
