package com.javaassignment.qthree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

/*
 * 3)	Design a Java program to implement a Collection Management System that manages 
 * 		different types of collections such as lists, sets, and maps. 
 * 		The program should allow users to perform the following operations for each type of collection:
 *
 *			a) Lists:
 *				i)		Add an element: The user can add an element to the list.
 *				ii)		Remove an element: The user can remove an element from the list.
 *				iii)	Display all elements: The user can view all elements in the list.
 *			
 *			b) Sets:
 *       i)		Add an element: The user can add an element to the set.
 *       ii)	Remove an element: The user can remove an element from the set.
 *       iii)	Display all elements: The user can view all elements in the set.
 *       iv)	Implement exception handling to handle possible errors 
 *       			(e.g., element not found in the list/set, duplicate keys in the map).
 *				v)	Provide a user-friendly console interface for the user to interact with the 
 *						Collection Management System.
 */

public class JavaQ3 {

	private static List<String> CMSList = new ArrayList<>();
	private static Set<String> CMSSet = new HashSet<>();
	private static Map<String, String> CMSMap = new HashMap<>();
	
	// Method for managing List Operations
	private static void manageList(Scanner sc) {
		boolean continueListOps = true;
		
		while (continueListOps) {
			System.out.println("\n========== List Management ==========");
			System.out.println("1. Add an Element to the List");
			System.out.println("2. Remove an Element from the List");
			System.out.println("3. Display All Elements from the List");
			System.out.println("4. Back to Main Menu");
			System.out.println("\nChoose an option: ");
			int ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
				case 1:
					System.out.println("\nEnter an element to add: ");
					String elementToAddList = sc.nextLine();
					CMSList.add(elementToAddList);
					System.out.println("\n" + elementToAddList + " added to the list.");
					break;
					
				case 2:
					System.out.println("\nEnter an element to remove from the list: ");
					String elementToRemoveList = sc.nextLine();
					try {
						if(CMSList.remove(elementToRemoveList)) {
							System.out.println("\n" + elementToRemoveList + " removed from the list.");
						} else {
							throw new NoSuchElementException("\nElement not found in the list!");
						}
					} catch (NoSuchElementException ex) {
						System.out.println(ex.getMessage());
					}
					break;
					
				case 3:
					System.out.println("\nElements in the List: " + CMSList);
					break;
					
				case 4:
					continueListOps = false;
					System.out.println("\nExiting the List Operations...");
					break;
				
				default:
					System.out.println("\nInvalid choice! Please select a valid option.");
			}
		}
	}
	
	// Method for managing Set Operations
	private static void manageSet(Scanner sc) {
		boolean continueSetOps = true;
		
		while(continueSetOps) {
			System.out.println("\n========== Set Management ==========");
			System.out.println("1. Add an Element to the Set");
			System.out.println("2. Remove an Element from the Set");
			System.out.println("3. Display All Elements from the Set");
			System.out.println("4. Back to Main Menu");
			System.out.println("\nChoose an option: ");
			int ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
				case 1:
					System.out.println("\nEnter an element to add: ");
					String elementToAddSet = sc.nextLine();
					if(CMSSet.add(elementToAddSet)) {
						System.out.println(elementToAddSet + " added to the set.");
					} else {
						System.out.println("\n" + elementToAddSet + " element already exists in the set.");
					}
					break;
					
				case 2:
					System.out.println("\nEnter an element to remove from the set: ");
					String elementToRemoveSet = sc.nextLine();
					try {
						if(CMSSet.remove(elementToRemoveSet)) {
							System.out.println("\n" + elementToRemoveSet + " removed from the set.");
						} else {
							throw new NoSuchElementException("\nElement not found in the set.");
						}
					} catch(NoSuchElementException ex) {
						System.out.println(ex.getMessage());
					}
					break;
					
				case 3:
					System.out.println("\nElements in the Set: " + CMSSet);
					break;
					
				case 4:
					continueSetOps = false;
					System.out.println("\nExiting the Set Operations...");
					break;
					
				default:
					System.out.println("\nInvalid choice! Please select a valid option.");
			}
		}
	}
	
	// Method for managing Map Operations
	private static void manageMap(Scanner sc) {
		boolean continueMapOps = true;
		
		while(continueMapOps) {
			System.out.println("\n========== Map Management ==========");
			System.out.println("1. Add key-Value pair to the Map");
			System.out.println("2. Remove Key from the Map");
			System.out.println("3. Display All Key-Value pairs from the Map");
			System.out.println("4. Back to Main Menu");
			System.out.println("\nChoose an option: ");
			int ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
				case 1:
					System.out.println("\nEnter a Key: ");
					String key = sc.nextLine();
					System.out.println("\nEnter a Value: ");
					String value = sc.nextLine();
					
					if(CMSMap.containsKey(key)) {
						System.out.println("\nDuplicate key found! Overwriting existing value.");
					}
					CMSMap.put(key, value);
					System.out.println("\nKey-Value pair added: " + key + " -> " + value);
					break;
					
				case 2:
					System.out.println("\nEnter a key to remove: ");
					String keyToRemove = sc.nextLine();
					try {
						if(CMSMap.remove(keyToRemove) != null) {
							System.out.println("\nKey " + keyToRemove + " removed from the map.");
						} else {
							throw new NoSuchElementException("\nKey not found !");
						}
					} catch(NoSuchElementException ex) {
						System.out.println(ex.getMessage());
					}
					break;
					
				case 3:
					System.out.println("\nMap entries: " + CMSMap);
					break;
					
				case 4:
					continueMapOps = false;
					System.out.println("\nExiting the Map Operations...");
					break;
					
				default:
					System.out.println("\nInvalid choice! Please select a valid option.");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean continueProgram = true;
		
		while (continueProgram) {
			System.out.println("\n*************** Collection Management System ***************");
			System.out.println("Hello, here's what our ColMS can do:");
			System.out.println("1. List Management");
			System.out.println("2. Set Management");
			System.out.println("3. Map Management");
			System.out.println("4. Exit ColMS");
			System.out.println("\nChoose an option: ");
			int ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
				case 1:
					manageList(sc);
					break;
					
				case 2:
					manageSet(sc);
					break;
					
				case 3:
					manageMap(sc);
					break;
					
				case 4:
					continueProgram = false;
					System.out.println("\nThank you for using ColMS, Quiting Collection Management System...");
					break;
					
				default:
					System.out.println("\nInvalid choice! Please select a valid option.");
			}
		}
		sc.close();
	}

}
