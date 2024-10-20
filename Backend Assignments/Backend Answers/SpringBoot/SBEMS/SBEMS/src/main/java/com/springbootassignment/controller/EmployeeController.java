package com.springbootassignment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootassignment.dao.EmployeeRequest;
import com.springbootassignment.dao.EmployeeVO;
import com.springbootassignment.service.IEmployeeService;

@RestController
@RequestMapping("/api/v1/ems")
public class EmployeeController {
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private IEmployeeService employeeService;
	
	// Fetch all employees
	@GetMapping
	public ResponseEntity<List<EmployeeVO>> getEmployees(){
		List<EmployeeVO> employeeVOS = null;
		
		log.info("Inside EmployeeController and calling the getEmployees method...");
		employeeVOS = employeeService.findAll();
		return new ResponseEntity<List<EmployeeVO>>(employeeVOS, HttpStatus.OK);
	}
	
	// Create or save new employee
	@PostMapping
	public ResponseEntity<EmployeeVO> save(@RequestBody EmployeeRequest employeeRequest){
		log.info("Inside EmployeeController.save and employeeRequest: {}", employeeRequest);
		
		if(employeeRequest == null) {
			log.info("Invalid employee request");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		EmployeeVO employeeVO = null;
		
		try {
			employeeVO = employeeService.save(employeeRequest);
			if(employeeVO == null) {
				log.info("Employee details are nor saved.");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception ex) {
			log.info(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<EmployeeVO>(employeeVO, HttpStatus.OK);
	}
	
	// Update an employee
	@PutMapping
	public ResponseEntity<EmployeeVO> update(@RequestBody EmployeeRequest employeeRequest){
		log.info("Inside EmployeeController.update and employeeRequest: {}", employeeRequest);
		
		if(employeeRequest == null) {
			log.info("Invalid request!");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		EmployeeVO employeeVO = null;
		
		try {
			employeeVO = employeeService.save(employeeRequest);
			if(employeeVO == null) {
				log.info("Employee details not updated.");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception ex) {
			log.info("Error while updating employee details!");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(employeeVO, HttpStatus.OK);
	}
	
	// Delete an employee
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestParam("id") int empID){
		log.info("Input to EmployeeController.delete, id: {}", empID);
		String response = null;
		
		try {
			response = employeeService.delete(empID);
		} catch(Exception ex) {
			log.info("Exception while deleting employee!");
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
