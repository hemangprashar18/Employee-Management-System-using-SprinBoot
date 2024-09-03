package com.example.em_project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class EmpContoller {
    // EmployeeService employeeService = new EmployeeServiceImplement();  //ye nhi karenge kyuki baar baar new karoge toh new memory allocate hori hogi , so baar baar 10 classes ke liye 10 object thodu banayenge

    // Dependency Injection
    @Autowired
    // autowired is written to keep track ki yha dependency injection hori hai
    EmployeeService employeeService;   // it is not good practice , we inject dependency in constructor

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.readEmployee(id);
    }
    

    // here Employee is class and employee is object. this time RequestBody coz hume body se data leke aare hain
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        //TODO: process POST request
        // employees.add(employee);
        return employeeService.createEmployee(employee);
    }

    // {id} -> it is path variable. PathVariable is done coz ye jo bhi url se data aara hoga usko fetch karlega
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        if(employeeService.deleteEmployee(id)){
            return "Deleted Succesfully";
        }
        return "Not Found";
    }
    
    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable int id, @RequestBody Employee employee) {
        //TODO: process PUT request
        return employeeService.updateEmployee(id, employee);
    }
    
}
