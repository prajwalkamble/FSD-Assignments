package com.springbootassignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Design a Spring Boot program to create a CRUD (Create, Read, Update, Delete) application using Hibernate for managing employee records. The program should allow users to perform the following operations on the employee database:
 * a)	Add a new employee: The user can enter details like employee name, department, and salary, and 
 * 		the program should add the employee to the database.
 * b)	Update employee details: The user can update the name, department, or salary of an 
 * 		existing employee based on their employee ID.
 * c)	Delete an employee: The user can delete an employee from the database based on their employee ID.
 * d)	Display all employees: The program should retrieve and display a list of all employees and 
 * 		their details from the database.
 * e)	Requirements:
 * 		i)		Use Spring Boot to create the application and Hibernate to manage the database.
 * 		ii)		Implement JPA (Java Persistence API) for data access.
 * 		iii)	Provide a RESTful API for performing CRUD operations on employees.
 * 		iv)		Implement exception handling to handle possible errors during database interactions.
 * 		v)		Cover Spring Boot and Hibernate topics, such as entity classes, repositories, services, 
 * 					and controllers.
 * f)	Note: Before running the program, make sure you have set up the database and configured the 
 * 		connection in the application.properties file.
 */

@SpringBootApplication
public class SbemsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SbemsApplication.class);

	public static void main(String[] args) {
		
		// Log a debug message when the application starts loading
		log.debug("Hey There! Employee Management System is liading...");
		
		// Starting Spring Boot application
		SpringApplication.run(SbemsApplication.class, args);
		
		// Log an info message when the application is running
		log.info("Employee Management System is now running !!!");
	}

}
