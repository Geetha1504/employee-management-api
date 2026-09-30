package com.projects.employee_management_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.employee_management_api.entity.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByNameContainingIgnoreCase(String name);

	List<Employee> findByDepartmentIgnoreCase(String department);
}
