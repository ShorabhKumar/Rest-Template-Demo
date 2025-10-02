package com.tutorial.deparments.Services;

import com.tutorial.deparments.Model.Departments;

import java.util.List;
import java.util.Optional;

public interface DepartmentsServices {

    List<Departments> getAllDepartments();

    Departments saveDepartments(String departmentName, String departmentDescription);

    void deleteDepartments(Long id);

    Optional<Departments> getDepartmentsById(Long id);
}
