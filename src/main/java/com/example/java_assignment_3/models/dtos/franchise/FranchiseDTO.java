package com.example.java_assignment_3.models.dtos.franchise;

import lombok.Data;

import java.util.Set;

@Data
public class FranchiseDTO {
    private int franchiseId;
    private String franchiseName;
    private String franchiseDescription;
    private Set<Integer> movies;
}
