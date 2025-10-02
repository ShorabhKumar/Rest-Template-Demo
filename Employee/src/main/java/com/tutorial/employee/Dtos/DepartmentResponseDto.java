package com.tutorial.employee.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDto {
    private Long id;
    private String departmentName;
    private String departmentDescription;
}
