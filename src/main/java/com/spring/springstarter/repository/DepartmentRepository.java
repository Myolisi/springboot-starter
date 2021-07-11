package com.spring.springstarter.repository;

import com.spring.springstarter.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    // Custom query to return the department based on input
    // Ignore case
    @Query("SELECT u FROM Department u WHERE lower(u.departmentName) LIKE lower(concat('%',:name, '%')) OR u.departmentCode LIKE lower(concat('%', :name, '%') ) ")
    public List<Department> findAndSearch(String name);
}
