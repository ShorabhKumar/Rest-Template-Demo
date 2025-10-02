package com.tutorial.employee.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseModel {

    @Column(name="emp_name")
    private String empName;

    @Column(name="emp_department")
    private Long empDepartment;

    @Column(name="emp_salary")
    private Double empSalary;

    @Column(name = "age")
    private Integer age;
}
