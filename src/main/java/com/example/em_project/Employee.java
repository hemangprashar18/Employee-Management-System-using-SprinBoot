// Entity class is needed to map with table

package com.example.em_project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// by importing data -> it will solve the problem of getters and setters which were needed to set name and get user coz name,phone is private not public
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String phone;
    private String email;
}
