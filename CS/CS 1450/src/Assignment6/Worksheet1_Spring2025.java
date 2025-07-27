package Assignment6;
// CS1450 Assignment #6 Spring 2025
// Worksheet #1: Stacks
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Worksheet1_Spring2025 {

	public static void main(String[] args) throws IOException {
		
		// Name of file to read from
		final String PLANES_FILE_NAME = "Worksheet1Planes_Spring2025.txt";	

		// Setup a file reference variable to refer to text file
		File planesFileName = new File(PLANES_FILE_NAME);

		// First value in file is the number of planes in the file
		Scanner planesFile = new Scanner (planesFileName);
		int numPlanesInFile = planesFile.nextInt();

		//****************************************
		// Worksheet1 Question #2: 
		// Write code to create a stack of planes
		//*****************************************
		// ADD YOUR CODE HERE

		GenericStackW1<PlaneW1> planeStack = new GenericStackW1<>();
		
		GenericStackW1<SemiTruckW1> truckStack = new GenericStackW1<>();
		
		
		// Create plane objects from the details provided in the file
		for(int i = 0; i < numPlanesInFile; i++) {
			
			// Read information from file and create a plane
			double capacity = planesFile.nextDouble();
			String cargoType = planesFile.next();
			
			PlaneW1 plane = new PlaneW1(capacity, cargoType);		

			// Print the plane's details
			System.out.println(plane.getCapacity() + " " + plane.getCargoType());
	
			//****************************************
			// Worksheet1 Question #3: 
			// Write code to add the plane to the stack
			//****************************************
			// ADD YOUR CODE HERE
			
			planeStack.push(plane);
			
		} // for each plane
		
		
		//****************************************
		// Worksheet1 Question #4
		// Write code to print the capacity of each plane on the stack.  
		// Look in the file to see the capacity of the plane.
		// Use a while loop to perform this task.
		//****************************************
		// ADD YOUR CODE HERE
		System.out.println();
		System.out.println();
		System.out.println("Planes on Stack");
		System.out.println("---------------------------------");
		
		//Displays Plane Capacity 
		while(!planeStack.isEmpty()) {
			
			System.out.printf("Capacity: %10.2f\n", planeStack.pop().getCapacity());
			
		}//While 
		

		
		//****************************************
		// Worksheet1 Question #5
		// Write one line of code to access the top element on the stack without removing it  
		//****************************************
		// ADD YOUR CODE HERE
		System.out.println();
		System.out.println();
		
		
		PlaneW1 topOfStack = planeStack.pop();
	
		planesFile.close();

	} // main

} // Worksheet1

//Class representing the generic stack - named it GenericStackW1 to avoid name clashing issues
class GenericStackW1<E>  {

	private ArrayList<E> list;		// Storage for stack is provided by an ArrayList
	
	public GenericStackW1() {
		list = new ArrayList<>();	// Allocate memory
	}
	
	public boolean isEmpty (){
		return list.isEmpty();
	}
	
	public int getSize(){
		return list.size();
	}

	// Returns the top element on the top without removing it
	// Since using array list to store elements, this means getting the last element in the array
	public E peek(){
		return list.get(getSize() - 1);
	}
	
	// Removed and returns the top element on the stack 
	// Since using array list to store elements, this means removing the last element in the array
	public E pop(){		
		E value = list.remove(getSize() - 1);
		return value;
	}

	// Place a new element on the top of the stack
	// Since using array list to store elements, this means adding the element to the array
	public void push(E value){
		list.add(value); 
	}
	
} // GenericStackW1


//Represents a plane - named it PlaneW1 due to name clashing issues - so many planes! 
class PlaneW1 { 
	
	private double capacity;
	private String cargoType;
			
	// Create a plane
	public PlaneW1 (double capacity, String cargoType) {
		this.capacity = capacity;
		this.cargoType = cargoType;
	}
			
	public double getCapacity() {
		return capacity;
	}
	
	public String getCargoType() {
		return cargoType;
	}

} // PlaneW1


//Represents a semi-truck - named it SemiTruckW1 due to name clashing issues - so many planes! 
class SemiTruckW1  {

	private int truckNumber;			// Semi-truck's number

	public SemiTruckW1(int truckNumber) {
		this.truckNumber = truckNumber;
	}
	
	public int getTruckNumber() {
		return truckNumber;
	}
	
} // SemiTruckW1


