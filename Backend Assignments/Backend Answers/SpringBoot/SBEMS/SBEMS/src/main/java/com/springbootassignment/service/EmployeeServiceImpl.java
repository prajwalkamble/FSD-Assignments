package com.springbootassignment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootassignment.dao.EmployeeRequest;
import com.springbootassignment.dao.EmployeeVO;
import com.springbootassignment.entity.EmployeeEntity;
import com.springbootassignment.exception.EmployeeNotFoundException;
import com.springbootassignment.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public List<EmployeeVO> findAll() {
		log.info("Inside EmployeeServiceImpl findAll method...");
		List<EmployeeEntity> employees = employeeRepository.findAll();
		log.info("Fetching all Employees response: {}", employees);
		
		// Mapping the entities to DTOs
		List<EmployeeVO> employeeVOS = employees.parallelStream().map(employee -> {
					EmployeeVO employeeVO = new EmployeeVO();
					employeeVO.setEmpID(employee.getEmpID());
					employeeVO.setEmpName(employee.getEmpName());
					employeeVO.setEmpDept(employee.getEmpDept());
					employeeVO.setEmpSalary(employee.getEmpSalary());
					return employeeVO;
				}).collect(Collectors.toList());
		
		return employeeVOS;
	}

	@Override
	public EmployeeVO findById(int empID) throws EmployeeNotFoundException {
		log.info("Inside EmployeeServiceImpl findById method...");
		Optional<EmployeeEntity> employee = employeeRepository.findById(Long.valueOf(empID));
		log.info("Fetching an Employee response: {}", employee);
		
		if(!employee.isPresent()) {
			log.error("No Employee found!");
			throw new EmployeeNotFoundException("No Employee Found!");
		} else {
			EmployeeEntity empEntity = employee.get();
			
			int employeeID = empEntity.getEmpID();
			
			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setEmpID(employeeID);
			employeeVO.setEmpName(empEntity.getEmpName());
			employeeVO.setEmpDept(empEntity.getEmpDept());
			employeeVO.setEmpSalary(empEntity.getEmpSalary());
			
			return employeeVO;
		}
	}

	@Override
	public EmployeeVO save(EmployeeRequest employeeRequest) throws EmployeeNotFoundException {
		log.info("Inside EmployeeServiceImpl save method and params, employeeRequest: {}", employeeRequest);
		
		if(employeeRequest == null) {
			log.info("Invalid Employee Request !");
			throw new EmployeeNotFoundException("Invalid Employee Request !");
		}
		
		EmployeeEntity employee = new EmployeeEntity();
		
		if(employeeRequest.getEmpID() > 0) {
			employee.setEmpID(employeeRequest.getEmpID());
		}
		employee.setEmpName(employeeRequest.getEmpName());
		employee.setEmpDept(employeeRequest.getEmpDept());
		employee.setEmpSalary(employeeRequest.getEmpSalary());
		
		EmployeeEntity employeeResponse = employeeRepository.save(employee);
		
		EmployeeVO employeeVO = null;
		
		if(employeeResponse != null) {
			log.info("Employee Response, employeeResponse: {}", employeeResponse);
			employeeVO = new EmployeeVO();
			employeeVO.setEmpID(employee.getEmpID());
			employeeVO.setEmpName(employee.getEmpName());
			employeeVO.setEmpDept(employee.getEmpDept());
			employeeVO.setEmpSalary(employee.getEmpSalary());
		}
		
		return employeeVO;
	}

	@Override
	public String delete(int empID) throws EmployeeNotFoundException {
		
		log.info("Input to EmployeeServiceImpl delete method, id: {}", empID);
		if(empID < 0) {
			log.info("Invalid Employee ID!");
			throw new EmployeeNotFoundException("Invalid Employee ID!");
		}
		
		try {
			employeeRepository.deleteById(Long.valueOf(empID));
		} catch(Exception ex) {
			log.info("Exception while deteting employee!");
			throw new EmployeeNotFoundException("Exception while deteting employee!");
		}
		return "Emplpyee has been deleted successfully.";
	}
}
