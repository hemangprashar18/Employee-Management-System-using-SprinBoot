package com.example.em_project;

// here we just making an interface, means a blueprint

import java.util.List;

public interface  EmployeeService {
    String createEmployee(Employee employee);  // we have written String instead of Employee we are returning "Saved succesfully msg as a string"
    List<Employee> readEmployees();
    boolean deleteEmployee(int id); 
    String updateEmployee(int id, Employee employee);
    Employee readEmployee(int id);
}
