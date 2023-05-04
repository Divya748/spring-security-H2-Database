package com.divya.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divya.security.entity.Employee;
import com.divya.security.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Override
	public void addEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emps = (List<Employee>)employeeDao.findAll(); 
		return emps;
	}

	
}
