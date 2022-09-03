package com.example.java_assignment_3.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    private Set<Movie> movie;
}
