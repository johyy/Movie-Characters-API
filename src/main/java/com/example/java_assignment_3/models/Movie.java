package com.example.java_assignment_3.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @JsonGetter("franchise")
    public Integer jsonGetFranchise() {
        if (franchise != null)
            return franchise.getId();
        return null;
    }

    @JsonGetter("characters")
    public List<Integer> jsonGetCharacters() {
        if (characters != null)
            return characters.stream().map(s -> s.getId()).collect(Collectors.toList());
        return null;
    }
}
