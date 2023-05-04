package com.divya.security.service;

import java.util.List;

import com.divya.security.entity.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	List<Employee> getAllEmployees();

}
