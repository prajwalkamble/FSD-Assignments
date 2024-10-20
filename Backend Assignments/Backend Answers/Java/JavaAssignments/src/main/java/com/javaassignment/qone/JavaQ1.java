package com.javaassignment.qone;

/* Write a program to cover all the Java OOPs concepts. Topics need to cover:
 * a) Class and Object
 * b) Class constructor
 * c) Method overloading
 * d) Method overriding
 * e) Inheritance
 * f) Interface
 * g) Abstract class
 */

class Animal{
	String name;
	
	// b) Class constructor
	Animal(String name){
		this.name = name;
	}
	
	public void sound() {
		System.out.println("\nAnimal makes sound !");
	}
	
	// c) Method overloading
	public void sound(String sound) {
		System.out.println("\nAnimal makes a " + sound + " sound");
	}
}

class Dog{
	Dog(String name){
		super();
	}
	
	// d) Method overriding
	public void sound() {
		System.out.println("\nDog barks!!!");
	}
}

// g) Abstract class
abstract class Vehicle{
	abstract void move();
}

// e) Inheritance
class Car extends Vehicle{
	void move() {
		System.out.println("\nCar is moving!!!");
	}
}

// f) Interface
interface Playable{
	void play();
}

class Guitar implements Playable{
	public void play() {
		System.out.println("\nPlaying a Guitar...");
	}
}

public class JavaQ1 {

	public static void main(String[] args) {
		// Creating an object
		Animal animal = new Animal("Lion");
		animal.sound();
		animal.sound("roarrr!!!"); // Method overloading
		
		// Method overriding using inheritance
		Dog dog = new Dog("Great Dane");
		dog.sound();
		
		// Using abstract class
		Vehicle car = new Car();
		car.move();
		
		// Using interface
		Playable guitar = new Guitar();
		guitar.play();
	}

}
