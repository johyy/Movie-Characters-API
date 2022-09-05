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
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String franchiseName;
    @Column(length = 100)
    private String franchiseDescription;
    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;
}
