package com.tutorial.employee.Services;

import com.tutorial.employee.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServices {
    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    Employee saveEmployee(String EmpName, Long EmpDepartment, Double EmpSalary, Integer age);

    void deleteEmployeeById(Long id);
}
