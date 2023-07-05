package com.greatlearning.employeemanagement.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.dao.EmployeeRepository;
import com.greatlearning.employeemanagement.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository repository;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return  this.repository.findAll();
	}

	@Override
	public int deleteById(int id) {
		repository.deleteById(id);
		return id;
		
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> optemp = repository.findById(id);
		if(optemp.isPresent()) {
			return optemp.get();
			
		}
		return null;
	}

	@Override
	public void saveEmployee(Employee emp) {
		repository.save(emp);		
	}

	@Override
	public void updateEmployee(Employee emp) {
		
		repository.save(emp);
	}

}
