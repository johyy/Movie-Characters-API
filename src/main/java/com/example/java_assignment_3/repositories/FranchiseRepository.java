package com.example.java_assignment_3.repositories;

import com.example.java_assignment_3.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
    //business logic here
}
