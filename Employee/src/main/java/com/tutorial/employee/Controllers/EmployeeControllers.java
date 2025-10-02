package com.tutorial.employee.Controllers;

import com.tutorial.employee.Model.Employee;
import com.tutorial.employee.Services.EmployeeServicesImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeControllers {

    private final EmployeeServicesImpl employeeServices;

    public EmployeeControllers(EmployeeServicesImpl employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeServices.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeServices.getEmployeeById(id).get();
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeServices.saveEmployee(employee.getEmpName(), employee.getEmpDepartment(), employee.getEmpSalary(), employee.getAge());
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeServices.deleteEmployeeById(id);
    }
}
