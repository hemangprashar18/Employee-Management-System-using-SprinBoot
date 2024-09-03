package com.example.em_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    // if we need some custom method. i.e we have findbyId but we can't have findbyName so here we can make custom method to get name
}
