package com.example.em_project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="emp_db")        // its done to communicate with table , ye saare idname,etc column name hojaenge
public class EmployeeEntity {

    // it is done to create Id automatically.    GenerationType.IDENTITY se bhi hojata
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    
    private String name;
    private String phone;
    private String email;

}
