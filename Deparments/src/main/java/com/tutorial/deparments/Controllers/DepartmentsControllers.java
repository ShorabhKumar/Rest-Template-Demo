package com.tutorial.deparments.Controllers;

import com.tutorial.deparments.Model.Departments;
import com.tutorial.deparments.Services.DepartmentsServicesImpl;
import com.tutorial.deparments.Services.DepartmentsServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentsControllers {

    private final DepartmentsServices departmentsServices;

    public DepartmentsControllers(final DepartmentsServices departmentsServices) {
        this.departmentsServices = departmentsServices;
    }

    @GetMapping("/departments")
    public List<Departments> getAllDepartments(){
        return departmentsServices.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Departments getDepartmentsById(@PathVariable Long id){
        return departmentsServices.getDepartmentsById(id).get();
    }

    @PostMapping("/departments")
    public Departments saveDepartments(@RequestBody Departments request){
        return departmentsServices.saveDepartments(request.getDepartmentName(), request.getDepartmentDescription());
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartments(@PathVariable Long id){
        departmentsServices.deleteDepartments(id);
    }
}
