package com.jdbcassignment.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 5) Design a Java program to create a simple employee management system using JDBC and MySQL Connector/J. The program should allow users to perform the following operations:
 * 		a)	Add a new employee: The user can enter details like employee ID, name, department, and salary, 
 * 				and the program should add the employee to the database.
 * 		b)	Update employee details: The user can update the name, department, or salary of an existing 
 * 				employee based on their employee ID.
 * 		c)	Delete an employee: The user can delete an employee from the database based on their employee ID.
 * 		d)	Display all employees: The program should retrieve and display a list of all employees and their 
 * 				details from the database.
 * 		e)	Requirements:
 *				i)		Use JDBC and MySQL Connector/J to connect to the MySQL database and perform CRUD 
 *							(Create, Read, Update, Delete) operations.
 *				ii)		Implement exception handling to handle possible errors during database interactions.
 *				iii)	Provide a user-friendly console interface for the user to interact with the 
 *							employee management system.
 *				iv)		Cover Java topics such as classes, methods, user input and output (I/O), and 
 *							exception handling.
 *				f)		Note: Before running the program, make sure you have MySQL installed, create a database 
 *							named "employee_management," and a table named "employees" with columns: 
 *							"id" (INT, PRIMARY KEY), "name" (VARCHAR), "department" (VARCHAR), and "salary" (DOUBLE).
 */

public class EMS {
	// MySQL connection
	private static final String URL = "jdbc:mysql://localhost:3306/employeeDB";
	private static final String USER = "root";
	private static final String PASSWORD = "tHe.mR_J0KeR";

	// Add a new Employee to EMS
	private static void addEmployee(Connection conn, Scanner sc) {
		try {
			System.out.print("\nEnter Employee ID: ");
	    int id = sc.nextInt();
	    sc.nextLine(); // Consume newline
	    System.out.print("Enter Name: ");
	    String name = sc.nextLine();
	    System.out.print("Enter Department: ");
	    String department = sc.nextLine();
	    System.out.print("Enter Salary: ");
	    double salary = sc.nextDouble();
	    
	    String query = "INSERT INTO employees (empID, empName, empDept, empSalary) VALUES (?, ?, ?, ?)";
	    PreparedStatement stmt = conn.prepareStatement(query);
	    stmt.setInt(1, id);
	    stmt.setString(2, name);
	    stmt.setString(3, department);
	    stmt.setDouble(4, salary);
	    
	    int rows = stmt.executeUpdate();
	    if(rows > 0) {
	    	System.out.println("\nEmployee successfully added to EMS.");
	    }
		} catch(SQLException ex) {
			System.out.println("\nError: " + ex.getMessage());
		}
	}
	
	// Update Employee details from EMS
	private static void updateEmployee(Connection conn, Scanner sc) {
		try {
			System.out.print("Enter Employee ID you want to update: ");
	    int id = sc.nextInt();
	    sc.nextLine();
	    System.out.print("Enter Name (Press Enter/Leave Empty to keep as it is): ");
	    String name = sc.nextLine();
	    System.out.print("Enter Department (Press Enter/Leave Empty to keep as it is): ");
	    String department = sc.nextLine();
	    System.out.print("Enter Salary (Press Enter/Leave Empty to keep as it is): ");
	    double salary = sc.nextDouble();
	    
	    String query = "UPDATE employees SET empName = ?, empDept = ?, empSalary = ? WHERE empID = ?";
	    PreparedStatement stmt = conn.prepareStatement(query);
	    stmt.setString(1, name);
      stmt.setString(2, department);
      stmt.setDouble(3, salary);
      stmt.setInt(4, id);
	    
      int rows = stmt.executeUpdate();
      if(rows > 0) {
      	System.out.println("\nEmployee updated successfully.");
      } else {
      	System.out.println("\nEmploee not found!");
      }
		} catch(SQLException ex) {
			System.out.println("\nError: " + ex.getMessage());
		}
	}
	
	// Delete Employee details from EMS
	private static void deleteEmployee(Connection conn, Scanner sc) {
		try {
			System.out.println("\nEnter the Employee ID you want to delete: ");
			int id = sc.nextInt();
			
			String query = "DELETE FROM employees WHERE empID = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			
			int rows = stmt.executeUpdate();
			if(rows > 0) {
				System.out.println("\nEmployee Details deleted successfully from EMS.");
			} else {
				System.out.println("\nEmployee not found!");
			}
		} catch(SQLException ex) {
			System.out.println("\nError: " + ex.getMessage());
		}
	}
	
	// Display all Employees from EMS
	private static void displayAllEmployees(Connection conn) {
		try {
			String query = "SELECT * FROM employees";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println("\n---------- Employees List ----------");
			while(rs.next()) {
				System.out.printf("\nID: %d, \nName: %s, \nDepartment: %s, \nSalary: %.2f\n",
						rs.getInt("empID"), rs.getString("empName"), rs.getString("empDept"), rs.getDouble("empSalary"));
			}
		} catch(SQLException ex) {
			System.out.println("\nError: " + ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			while(true) {
				System.out.println("\n*************** Employee Management System ***************");
				System.out.println("Hello, here's what our EMS can do: ");
				System.out.println("1. Add an Employee to EMS");
				System.out.println("2. Update Employee Details");
				System.out.println("3. Delete an employee details from EMS");
				System.out.println("4. Display All Employees in EMS");
				System.out.println("5. Exit EMS");
				System.out.println("\nChoose an option: ");
				int ch = sc.nextInt();
				
				switch(ch) {
					case 1:
						addEmployee(conn, sc);
						break;

					case 2:
						updateEmployee(conn, sc);
						break;

					case 3:
						deleteEmployee(conn, sc);
						break;

					case 4:
						displayAllEmployees(conn);
						break;

					case 5: 
						{
							conn.close();
							System.out.println("\nThank you for using EMS. Quiting Employee Management System.");
							System.exit(0);
						}
						break;
					
					default:
						System.out.println("\nInvalid choice! Please try again");
				}
			}
		} catch(SQLException ex) {
			System.out.println("\nDatabase Error: "+ ex.getMessage());
		}
	}

}
