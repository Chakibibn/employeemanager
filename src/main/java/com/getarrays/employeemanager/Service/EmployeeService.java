package com.getarrays.employeemanager.Service;

import com.getarrays.employeemanager.Exception.UserNotFoundException;
import com.getarrays.employeemanager.Model.Employee;
import com.getarrays.employeemanager.Repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class EmployeeService  {
    @Autowired
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return  employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long Id){
        return employeeRepo.findEmployeeById(Id)
                .orElseThrow(()-> new UserNotFoundException("User By id "+Id+"was not Found"));
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
