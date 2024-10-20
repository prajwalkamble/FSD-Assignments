package com.springbootassignment.service;

import java.util.List;

import com.springbootassignment.dao.EmployeeRequest;
import com.springbootassignment.dao.EmployeeVO;
import com.springbootassignment.exception.EmployeeNotFoundException;

public interface IEmployeeService {
	
	// Fetch all Employees
	List<EmployeeVO> findAll();
	
	// Find Employee by ID
	EmployeeVO findById(int empID) throws EmployeeNotFoundException;
	
	// Create or update an Employee
	EmployeeVO save(EmployeeRequest employeeRequest) throws EmployeeNotFoundException;
	
	// Delete an Employee by ID
	String delete(int empID) throws EmployeeNotFoundException;
}
