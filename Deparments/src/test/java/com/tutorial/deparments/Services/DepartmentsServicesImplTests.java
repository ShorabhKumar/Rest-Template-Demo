package com.tutorial.deparments.Services;

import com.tutorial.deparments.Model.Departments;
import com.tutorial.deparments.Repository.DepartmentsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DepartmentsServicesImplTests {
    @InjectMocks
    private DepartmentsServicesImpl departmentsServices;

    @Mock
    private DepartmentsRepository departmentsRepository;

    private List<Departments> mockDepartments;

    @BeforeEach
    void setUp() {
        Departments departmentsIT = new Departments();
        departmentsIT.setDepartmentName("IT");
        departmentsIT.setDepartmentDescription("IT department");
        departmentsIT.setCreatedAt(new Date());
        departmentsIT.setUpdatedAt(new Date());
        departmentsIT.setIsDeleted(false);
        departmentsIT.setId(1L);

        Departments departmentsMarketing = new Departments();
        departmentsMarketing.setDepartmentName("Marketing");
        departmentsMarketing.setDepartmentDescription("Marketing department");
        departmentsMarketing.setCreatedAt(new Date());
        departmentsMarketing.setUpdatedAt(new Date());
        departmentsMarketing.setIsDeleted(false);
        departmentsMarketing.setId(2L);

        mockDepartments = List.of(departmentsIT, departmentsMarketing);
    }
    @Test
    void testCount() {
        assertEquals(5, 3+2);
    }

    @Test
    void testGetAllDepartments() {
        //When
        when(departmentsRepository.findAll()).thenReturn(mockDepartments);

        List<Departments> departments = departmentsServices.getAllDepartments();

        //then
        assertEquals(2, departments.size());
        assertEquals("IT", departments.get(0).getDepartmentName());
        assertEquals("Marketing", departments.get(1).getDepartmentName());
    }

    @Test
    void testGetDepartmentsById() {
        //when
        when(departmentsRepository.findById(1L)).thenReturn(mockDepartments.stream().findFirst());
        Optional<Departments> departments = departmentsServices.getDepartmentsById(Long.valueOf(1));

        //then
        assertEquals("IT", departments.get().getDepartmentName());
        assertEquals("IT department", departments.get().getDepartmentDescription());
    }

    @Test
    void testDeleteDepartments() {
        //when
        departmentsServices.deleteDepartments(1L);

        //then
        assertEquals(1, 1);
        verify(departmentsRepository, times(1)).deleteById(1L);
    }

    @Test
    void testSaveDepartments(){
        Departments departments = new Departments();
        departments.setDepartmentName("Finance");
        departments.setDepartmentDescription("Finance department");
        departments.setCreatedAt(new Date());
        departments.setUpdatedAt(new Date());
        departments.setIsDeleted(false);
        departments.setId(3L);

        //When
        when(departmentsRepository.save(any(Departments.class))).thenReturn(departments);
        Departments savedDepartments = departmentsServices.saveDepartments(departments.getDepartmentName(), departments.getDepartmentDescription());

        //Then
        assertNotNull(savedDepartments);
        assertEquals("Finance", savedDepartments.getDepartmentName());
        assertEquals("Finance department", savedDepartments.getDepartmentDescription());
        verify(departmentsRepository, times(1)).save(any(Departments.class));
    }
}
