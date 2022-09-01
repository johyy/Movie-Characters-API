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
    private int movieId;
    @Column(length = 50, nullable = false)
    private String movieTitle;
    @Column(length = 50)
    private String movieGenre;
    @Column(length = 50)
    private String movieDirector;
    @Column(length = 100)
    private String moviePicture;
    @Column(length = 100)
    private String movieTrailer;
    @OneToMany(mappedBy = "movie")
    private Set<Character> charachter;
    @ManyToOne
    @JoinColumn(name = "franchiseId")
    private Franchise franchise;
}
