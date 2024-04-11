package com.greatlearning.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementSystem.entity.Employee;

@Service
public interface EmployeeService {

	List<Employee> getAllemployees();
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(int id);
	void deleteEmployeeById(int id);
	Employee updateEmployee(int id, Employee newEmployee);
}
