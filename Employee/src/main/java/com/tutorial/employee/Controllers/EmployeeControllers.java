package com.tutorial.employee.Controllers;

import com.tutorial.employee.Dtos.DepartmentResponseDto;
import com.tutorial.employee.Dtos.EmployeeResponseDto;
import com.tutorial.employee.Dtos.EmployeeWithDepartment;
import com.tutorial.employee.Model.Departments;
import com.tutorial.employee.Model.Employee;
import com.tutorial.employee.Services.DepartmentServicesImpl;
import com.tutorial.employee.Services.EmployeeServicesImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmployeeControllers {

    private final EmployeeServicesImpl employeeServices;

    private final DepartmentServicesImpl departmentServices;

    public EmployeeControllers(EmployeeServicesImpl employeeServices, DepartmentServicesImpl departmentServices) {
        this.employeeServices = employeeServices;
        this.departmentServices = departmentServices;
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeServices.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public EmployeeWithDepartment getEmployeeById(@PathVariable Long id){
        Optional<Employee> employee = employeeServices.getEmployeeById(id);
        EmployeeWithDepartment response = new EmployeeWithDepartment();

        if(employee.isPresent()){
            Employee employeeInfo = employee.get();
            EmployeeResponseDto employeeDto = new EmployeeResponseDto(
                    employeeInfo.getId(),
                    employeeInfo.getEmpName(),
                    employeeInfo.getEmpDepartment(),
                    employeeInfo.getEmpSalary(),
                    employeeInfo.getAge()
            );
            response.setEmployee(employeeDto);

            Optional<Departments> department = departmentServices.getDepartmentById(employee.get().getEmpDepartment());
            if(department.isPresent()){
                DepartmentResponseDto departmentDto = new DepartmentResponseDto(
                        department.get().getId(),
                        department.get().getDepartmentName(),
                        department.get().getDepartmentDescription()
                );
                response.setDepartment(departmentDto);
            }
        }
        return response;
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeServices.saveEmployee(employee.getEmpName(), employee.getEmpDepartment(), employee.getEmpSalary(), employee.getAge());
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeServices.deleteEmployeeById(id);
    }

    @GetMapping("/departments")
    public List<Departments> getAllDepartments(){
        return departmentServices.getAllDepartments();
    }

    @PostMapping("/departments")
    public Departments saveDepartment(@RequestBody Departments department){
        return departmentServices.saveDepartment(department.getDepartmentName(), department.getDepartmentDescription());
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable Long id){
        departmentServices.deleteDepartmentById(id);
        return "Department Deleted Successfully";
    }
}
