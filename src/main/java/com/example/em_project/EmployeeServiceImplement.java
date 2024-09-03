package com.example.em_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplement implements EmployeeService{

    @Autowired
    // to inject employee repository
    private EmployeeRepository employeeRepository;

    // List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        // TODO Auto-generated method stub
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);
        // employees.add(employee);
        return  "Saved succesfully";
    }

    @Override
    public Employee readEmployee(int id) {
        // TODO Auto-generated method stub
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);

        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
        // TODO Auto-generated method stub
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeesList) {
            
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());

            employees.add(emp);
            
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) {
        // TODO Auto-generated method stub
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(int id, Employee employee) {
        // TODO Auto-generated method stub
        EmployeeEntity existingEmp = employeeRepository.findById(id).get();

        existingEmp.setEmail(employee.getEmail());
        existingEmp.setName(employee.getName());
        existingEmp.setPhone(employee.getPhone());

        employeeRepository.save(existingEmp);
        return "Updated Succesfully";
    }

    

}
