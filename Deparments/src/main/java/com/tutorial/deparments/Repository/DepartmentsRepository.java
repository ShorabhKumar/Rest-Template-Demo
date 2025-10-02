package com.tutorial.deparments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tutorial.deparments.Model.Departments;

@Repository
    public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
    //method
}
