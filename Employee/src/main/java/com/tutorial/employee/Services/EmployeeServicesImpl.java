package com.tutorial.employee.Services;

import com.tutorial.employee.Model.Employee;
import com.tutorial.employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee saveEmployee(String empName, Long empDepartment, Double empSalary, Integer age) {
        Employee employee =new Employee();
        employee.setEmpName(empName);
        employee.setEmpDepartment(empDepartment);
        employee.setEmpSalary(empSalary);
        employee.setAge(age);
        employee.setIsDeleted(false);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
