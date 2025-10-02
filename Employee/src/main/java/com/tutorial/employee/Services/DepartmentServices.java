package com.tutorial.employee.Services;

import com.tutorial.employee.Model.Departments;

import java.util.List;
import java.util.Optional;

public interface DepartmentServices {

    Optional<Departments> getDepartmentById(Long id);

    List<Departments> getAllDepartments();

    Departments saveDepartment(String departmentName, String departmentDescription);

    void deleteDepartmentById(Long id);
}
