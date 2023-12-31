package com.greatlearning.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/")
	public String getAllEmployees(Model model) {
		model.addAttribute("employees", service.getAllEmployees());

		return "employees";

	}

	@GetMapping("/new")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());

		return "create_emp";

	}

	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable(name = "id") Integer id, Model model) {
		model.addAttribute("employee", service.findById(id));

		return "edit_emp";

	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") Integer id) {
		service.deleteById(id);
		return "redirect:/employees/";

	}

	@PostMapping("/save")
	public String createEmployee(@ModelAttribute(name = "employee") Employee emp) {
		service.saveEmployee(emp);
		return "redirect:/employees/";

	}

	@PostMapping("/save/{id}")
	public String createEmployee(@PathVariable(name = "id") Integer id,
			@ModelAttribute(name = "employee") Employee emp) {
		emp.setId(id);
		service.saveEmployee(emp);
		return "redirect:/employees/";

	}
}