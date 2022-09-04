package com.example.java_assignment_3.repositories;

import com.example.java_assignment_3.models.Franchise;
import com.example.java_assignment_3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {


}
