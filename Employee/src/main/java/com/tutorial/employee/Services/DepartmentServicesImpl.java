package com.tutorial.employee.Services;

import com.tutorial.employee.Model.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServicesImpl implements DepartmentServices{

    private final RestTemplate restTemplate;
    @Autowired
    public DepartmentServicesImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<Departments> getDepartmentById(Long id) {
        Departments department = restTemplate.getForObject("http://localhost:9002/api/departments/" + id, Departments.class);
        return Optional.ofNullable(department);
    }

    @Override
    public List<Departments> getAllDepartments(){
        List<Departments> departments = restTemplate.getForObject("http://localhost:9002/api/departments", List.class);
        return departments;
    }

    @Override
    public Departments saveDepartment(String departmentName, String departmentDescription){
        Departments department = new Departments();
        department.setDepartmentName(departmentName);
        department.setDepartmentDescription(departmentDescription);
        department.setIsDeleted(false);
        return restTemplate.postForObject("http://localhost:9002/api/departments", department, Departments.class);
    }

    @Override
    public void deleteDepartmentById(Long id){
        restTemplate.delete("http://localhost:9002/api/departments/" + id);
    }
}
