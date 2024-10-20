package com.javaassignment.qfour;
//import com.javaassignment.qfour.Employee;

import java.util.Scanner;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.InputMismatchException;

/*
 * Add new employees: The user can add details like employee ID, name, department, and salary.
 *  a)	Update employee details: The user can update the name, department, or salary of an 
 *  		existing employee based on their employee ID.
 *  b)	Delete an employee: The user can delete an employee from the system based on their employee ID.
 *  c)	Display all employees: The user can view a list of all employees and their details.
 *  d)	Search for an employee: The user can search for an employee by their employee ID and 
 *  		view their details.
 *  e)	Requirements:
 *   	i)		Use Object-Oriented Programming (OOP) principles and create an Employee class with 
 *   				appropriate attributes and methods.
 *   	ii)		Use appropriate data structures (e.g., ArrayList, HashMap) to store the employee data.
 *   	iii)	Implement exception handling to handle possible errors (e.g., invalid employee ID, 
 *   				input validation).
 *   	iv)		Provide a user-friendly console interface for the user to interact with the 
 *   				Employee Management System.
 */

public class JavaQ4 {
	
	private static Map<Integer, Employee> empMap = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);
	
	// Add an Employee to EMS
	private static void addEmployee() {
		try {
			System.out.println("\nEnter Employee ID: ");
			int empID = sc.nextInt();
			sc.nextLine();
			
			if(empMap.containsKey(empID)) {
				throw new IllegalArgumentException("\nEmployee with ID " + empID + " already exists.");
			}
			
			System.out.println("\nEnter Name: ");
			String empName = sc.nextLine();
			System.out.println("\nEmployee Department: ");
			String empDept = sc.nextLine();
			System.out.println("\nEmployee Salary: ");
			double empSalary = sc.nextDouble();
			
			Employee employee = new Employee(empID, empName, empDept, empSalary);
			empMap.put(empID, employee);
			System.out.println("\nEmployee with ID " + empID + " added successfully to EMS.");
		} catch(InputMismatchException ex) {
			System.out.println("\nInvalid inpput! Please try again.");
			sc.next();
		} catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	// Update Employee details
	private static void updateEmployee() {
		try {
			System.out.println("\nEnter the Employee ID you want to update: ");
			int empID = sc.nextInt();
			sc.nextLine();
			
			if(!empMap.containsKey(empID)) {
				throw new NoSuchElementException("\nEmployee not found!");
			}
			
			Employee employee = empMap.get(empID);
			
			System.out.println("\nEnter new Name (press enter/leave empty to keep unchanged): ");
			String empName = sc.nextLine();
			if(!empName.isEmpty()) {
				employee.setName(empName);
			}
			
			System.out.println("\nEnter new Department (press enter/leave empty to keep unchanged): ");
			String empDept = sc.nextLine();
			if(!empDept.isEmpty()) {
				employee.setDepartment(empDept);
			}
			
			System.out.println("\nEnter new Salary (press enter/leave empty to keep unchanged): ");
			double empSalary = sc.nextDouble();
			if(empSalary > 0) {
				employee.setSalary(empSalary);
			}
			
			System.out.println("\nEmployee details updated successfully.");
			
		} catch(InputMismatchException ex) {
			System.out.println("Invalid input! Please try again.");
			sc.next();
		} catch(NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	// Delete an Employee
	private static void deleteEmployee() {
		try {
			System.out.println("\nEnter the Employee ID you want to delete: ");
			int empID = sc.nextInt();
			
			if(empMap.remove(empID) != null) {
				System.out.println("\nEmployee with ID " + empID + " removed successfully.");
			} else {
				throw new NoSuchElementException("\nEmployee with ID " + empID + " not found.");
			}
		} catch(InputMismatchException ex) {
			System.out.println("\nInvalid input! Please try again.");
			sc.next();
		} catch(NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	// Display all Employees in EMS
	private static void displayAllEmployees() {
		if(empMap.isEmpty()) {
			System.out.println("\nNo employee details found in EMS!");
		} else {
			for(Employee employee : empMap.values()) {
				System.out.println();
				System.out.println(employee);
			}
		}
	}
	
	// Search an Employee in EMS
	private static void searchEmployee() {
		try {
			System.out.println("\nEnter the Employee ID you want to search: ");
			int empID = sc.nextInt();
			
			if(empMap.containsKey(empID)) {
				System.out.println(empMap.get(empID));
			} else {
				throw new NoSuchElementException("\nEmployee with ID " + empID + " not found in EMS!");
			}
		} catch(InputMismatchException ex) {
			System.out.println("\nInvalid input! Please try again.");
			sc.next();
		} catch(NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		boolean executeProgram = true;
		
		while(executeProgram) {
			System.out.println("\n*************** Employee Management System ***************");
			System.out.println("Hello, here's what our EMS can do:");
			System.out.println("1. Add an Employee");
			System.out.println("2. Update an Employee");
			System.out.println("3. Delete an Employee");
			System.out.println("4. Display all Employees");
			System.out.println("5. Search an Employee");
			System.out.println("6. Exit EMS!");
			System.out.println("\nChoose an option: ");
			int ch = sc.nextInt();
			
			switch(ch) {
				case 1:
					addEmployee();
					break;
				
				case 2:
					updateEmployee();
					break;
				
				case 3:
					deleteEmployee();
					break;
				
				case 4:
					displayAllEmployees();
					break;
				
				case 5:
					searchEmployee();
					break;
				
				case 6:
					executeProgram = false;
					System.out.println("\nThank you for using EMS, Quiting Employee Management System...");
					break;
				
				default:
					System.out.println("\nInvalid choice! Please select a valid option.");
			}
		}
		sc.close();
	}
}
