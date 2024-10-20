package com.javaassignment.qtwo;

import java.util.Scanner;

/* Design a Java program that performs various string operations and uses control statements for user 
 * input validation. The program should allow the user to perform the following operations:
 * 
 * a)	Extract Substring: The user can enter a string and specify the starting and ending index, 
 * 		and the program should extract and display the substring.
 * 
 * b) Split a Sentence: The user can enter a sentence, and the program should split it into words and 
 * 		display them.
 */

public class JavaQ2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean continueProgram = true;
		
		while(continueProgram) {
			System.out.println("\nAvailable operations: ");
			System.out.println("1. Extract Substring");
			System.out.println("2. Split Sentence");
			System.out.println("3. Exit");
			System.out.println("\nChoose an option:");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1:
					// a)	Extract Substring
					System.out.println("\nEnter a string: ");
					String inputString = sc.nextLine();
					System.out.println("\nEnter starting index: ");
					int start = sc.nextInt();
					System.out.println("\nEnter ending index: ");
					int end = sc.nextInt();
					
					if (start >= 0 && end <= inputString.length() && start < end) {
						String subString = inputString.substring(start, end);
						System.out.println("\nExtracted substring: " + subString);
					} else {
						System.out.println("\nInvalid input. Try again.");
					}
					break;
					
				case 2:
					// b) Split Sentence
					System.out.println("\nEnter a sentence: ");
					String sentence = sc.nextLine();
					String[] words = sentence.split("\\s+"); // split by space
					
					System.out.println("\nWords in the sentence: ");
					for (String word : words) {
						System.out.println(word);
					}
					break;
					
				case 3:
					// Exit the program
					continueProgram = false;
					System.out.println("\nExiting the program...");
					break;
				
				default:
					System.out.println("\nInvalid choice. Please choose again.");
          break;
			}
		}
		sc.close();
	}
}
