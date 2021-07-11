package com.spring.springstarter.interfaces;
import com.spring.springstarter.core.DepartmentNotFoundExeption;
import com.spring.springstarter.entity.Department;

import java.util.List;

public interface IDepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> getAllDepartments();
    public Department getById(Long id) throws DepartmentNotFoundExeption;
    public String deleteById(Long id);
    public Department updateDepartment(Long id, Department department);
    public List<Department> searchDepartment(String value);
}
