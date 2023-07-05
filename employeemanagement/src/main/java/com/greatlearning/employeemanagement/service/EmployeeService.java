package com.greatlearning.employeemanagement.service;

import java.util.List;


import com.greatlearning.employeemanagement.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	int deleteById(int id);
	
	Employee findById(int id);
	
	void saveEmployee(Employee emp);
	
	void updateEmployee(Employee emp);
	
	
	
	
	
}
