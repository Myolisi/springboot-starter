package com.spring.springstarter.controller;

import com.spring.springstarter.entity.Department;
import com.spring.springstarter.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);


    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/department")
    public List<Department> ping(){
        return departmentService.getAllDepartments();
    }

    @PostMapping(path = "/department")
    public Department saveDepartment(@Validated @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping(path = "/department/{id}" )
    public Department getDepartmentById(@PathVariable Long id){
        return departmentService.getById(id);
    }

    @DeleteMapping(path = "/department/{id}")
    public String deleteDepartmentById(@PathVariable Long id){
        return departmentService.deleteById(id);
    }

    @PutMapping(path = "/department/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department){
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping(path = "/department/search/{value}")
    public List<Department> searchDepartment(@PathVariable String value){
        System.out.println("value " + value );
        return departmentService.searchDepartment(value);
    }

}
