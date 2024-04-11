package com.greatlearning.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementSystem.entity.Employee;
import com.greatlearning.EmployeeManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllemployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}
	@Override
	public Employee updateEmployee(int id, Employee newEmployee) {
		Employee employee= employeeRepository.findById(id).get();
		employee.setFirstName(newEmployee.getFirstName());
		employee.setLastName(newEmployee.getLastName());
		employee.setEmail(newEmployee.getEmail());
		employeeRepository.save(employee);
		// TODO Auto-generated method stub
		return employee;
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		// TODO Auto-generated method stub

	}

}
