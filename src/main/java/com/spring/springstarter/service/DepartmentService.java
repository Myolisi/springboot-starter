package com.spring.springstarter.service;

import com.spring.springstarter.entity.Department;
import com.spring.springstarter.interfaces.IDepartmentService;
import com.spring.springstarter.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ObjectChecker;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    ObjectChecker checker = new ObjectChecker();

    private final DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Long id) {
        return departmentRepository.getById(id);
    }

    @Override
    public String deleteById(Long id) {
        departmentRepository.deleteById(id);
        return "Department deleted";
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        // add get() so that it returns the department object
        Department departmentToUpdate = departmentRepository.findById(id).get();


        if (checker.check(department.getDepartmentCode())){
            departmentToUpdate.setDepartmentCode(department.getDepartmentCode());
        }
        if (checker.check(department.getDepartmentAddress())){
            departmentToUpdate.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (checker.check(department.getDepartmentName())){
            departmentToUpdate.setDepartmentName(department.getDepartmentName());
        }
        return departmentRepository.save(departmentToUpdate);
    }

    @Override
    public List<Department> searchDepartment(String value) {
        return departmentRepository.findAndSearch(value);
    }
}
