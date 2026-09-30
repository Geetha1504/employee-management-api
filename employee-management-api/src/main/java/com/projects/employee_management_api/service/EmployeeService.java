package com.projects.employee_management_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.employee_management_api.entity.Employee;
import com.projects.employee_management_api.repository.EmployeeRepository;
import com.projects.employee_management_api.exception.EmployeeNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
	/*
	 * public Employee getEmployeeById(Long id) { return
	 * employeeRepository.findById(id).orElse(null); }
	 */
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
        		.orElseThrow(() -> new EmployeeNotFoundException(
        		        "Employee not found with id: " + id));
    }	
    
    public Employee updateEmployee(Long id, Employee employeeDetails) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found with id: " + id));

        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setSalary(employeeDetails.getSalary());

        return employeeRepository.save(employee);
    }
    
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found with id: " + id));

        employeeRepository.delete(employee);
    }
    
    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
    
    public List<Employee> searchByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Employee> searchByDepartment(String department) {
        return employeeRepository.findByDepartmentIgnoreCase(department);
    }
}