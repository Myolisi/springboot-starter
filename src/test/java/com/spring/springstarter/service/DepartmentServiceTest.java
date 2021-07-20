package com.spring.springstarter.service;

import com.spring.springstarter.core.DepartmentNotFoundExeption;
import com.spring.springstarter.entity.Department;
import com.spring.springstarter.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;


    Department department;

    @BeforeEach //we want to mock our data first
     void setUp() {
         department = Department.builder().departmentName("Computer Systems")
                 .departmentAddress("CompSys 203")
                 .departmentCode("cos-109")
                 .departmentId(1L)
                 .build();
    }

    @Test
    public void isDepartmentFound_findAndSearch() throws DepartmentNotFoundExeption {
        String searchValue = "cos-109";
        Mockito.when(departmentRepository.findAndSearch(searchValue)).thenReturn(List.of(department));

        List<Department> foundDepartment = departmentService.searchDepartment(searchValue);
        boolean allMatch =  foundDepartment.stream().allMatch(department -> department.getDepartmentCode().contains(searchValue));
        assertTrue(allMatch);
    }


    @Test
    public void canFindItemByID() throws DepartmentNotFoundExeption {
        final Long id = 1L;
        Mockito.when(departmentRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(department));
        final Department departmentFound = departmentService.getById(id);
        assertEquals(id, departmentFound.getDepartmentId());
    }

}