package com.greatlearning.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.EmployeeManagementSystem.entity.Employee;
import com.greatlearning.EmployeeManagementSystem.service.EmployeeService;

@Controller
public class EmployeeController {
		
	@Autowired
	EmployeeService employeeService;
	
	//Homepage for our app
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		List<Employee> empList=employeeService.getAllemployees();
		model.addAttribute("employees",empList);
		return "employees";
	}
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee",employee);
		return "create_employee";
	}
	@PostMapping("/employees")
	public String listEmployees(@ModelAttribute("employee")Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable("id")int id,Model model) {
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "edit_employee";
	}
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable("id")int id,@ModelAttribute("employee") Employee newEmployee) {
		Employee updatedEmployee=employeeService.updateEmployee(id,newEmployee);
		return "redirect:/employees";
	}
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id")int id, Model model) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
}
