package com.tutorial.deparments.Services;

import com.tutorial.deparments.Model.Departments;
import com.tutorial.deparments.Repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentsServicesImpl implements DepartmentsServices {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Override
    public List<Departments> getAllDepartments() {
        return departmentsRepository.findAll();
    }

    @Override
    public Departments saveDepartments(String departmentName, String departmentDescription) {
        Departments departments = new Departments();
        departments.setDepartmentName(departmentName);
        departments.setDepartmentDescription(departmentDescription);
        departments.setCreatedAt(new java.util.Date());
        departments.setUpdatedAt(new java.util.Date());
        departments.setIsDeleted(false);
        return departmentsRepository.save(departments);
    }

    @Override
    public Optional<Departments> getDepartmentsById(Long id) {
        return departmentsRepository.findById(id);
    }

    @Override
    public void deleteDepartments(Long id) {
        departmentsRepository.deleteById(id);
    }
}
