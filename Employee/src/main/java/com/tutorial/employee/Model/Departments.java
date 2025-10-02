package com.tutorial.employee.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departments {
    private Long Id;
    private String departmentName;
    private String departmentDescription;
    private Boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;
}
