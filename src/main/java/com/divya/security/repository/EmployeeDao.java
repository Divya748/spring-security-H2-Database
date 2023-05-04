package com.divya.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divya.security.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, String>{

}
