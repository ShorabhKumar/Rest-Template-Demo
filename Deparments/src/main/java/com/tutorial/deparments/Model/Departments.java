package com.tutorial.deparments.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="deparments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departments extends BaseModel {

    @Column(name="department_name")
    private String departmentName;

    @Column(name="department_description")
    private String departmentDescription;

    public Departments(long id, String departmentName, String departmentDescription) {
        super();
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
    }


}
