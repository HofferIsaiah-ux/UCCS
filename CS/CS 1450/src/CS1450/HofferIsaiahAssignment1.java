package cs1450;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/* 
Isaiah Hoffer 
CS1450 (M/W)
1/29/25
Assignment 1
This assignment will use a given array to make two more arrays that are even and odd. 
I will have to manipulate the arrays to get the desired output. 
*/


public class HofferIsaiahAssignment1 {

	public static void main(String[] args) throws IOException {
		
		//Create Main Array 
		int[] intArray = {1, 18, 10, 2, 16, 8, 15, 9, 9, 17, 14, 18, 1, 19, 18, 2, 1};
		
		//Displaying intArray
		for(int i = 0; i < intArray.length; i++) {
			
			System.out.printf("intArray[%d] = %d\n", i, intArray[i]);
		}//For
		
		//Sorting intArray 
		Arrays.sort(intArray);
		
		//Creating a File to write intArray to 
		File fileName = new File("Assignment1.txt");
		
		//Allowing File to be Written On 
		PrintWriter outputFile = new PrintWriter(fileName);
		
		//Counters 
		int evenAmount = 0;
		int oddAmount = 0;
		
		//Writing Array to File and Couting Even and Odd Values 
		for(int i = 0; i < intArray.length; i++) {
			
			if (intArray[i] % 2 == 0) {
				evenAmount++;
			}
			else if (intArray[i] % 2 == 1) {
				oddAmount++;
			}
			
			outputFile.println(intArray[i]);
			outputFile.flush();
		}//For
		
		//Displaing Counter Results 
		System.out.printf("\nTotal Values Written: %d \n"
				+ "Total Even Values:     %d \n"
				+ "Total Odd Values:      %d \n"
				+ "\nFile Can Be Found In: %s", 
					evenAmount + oddAmount, evenAmount, oddAmount, fileName.getAbsolutePath());
		
		
		//Allow Code to Read File 
		Scanner readFile = new Scanner(fileName);
		
		//Initalizing Even And Odd Arrays
		int[] evenIntArray = new int[evenAmount];
		int[] oddIntArray = new int[oddAmount];
		
		
		//Variables For Indexing and Used Later To Create Better Arrays 
		int evenArrayIndexAndSize = 0;
		int oddArrayIndexAndSize = 0;
		
		//Boolean To Reject Duplicates 
		boolean duplicateValue = false;
		//Reading File To Get Even and Odds Values
		//Only Runs When File Has Another Number 
		while(readFile.hasNextInt()) {
	
			duplicateValue = false;
			
			int currentNumber = readFile.nextInt();
				//Checking If Number is Even 
				if(currentNumber % 2 == 0) { 
					//Checking If Number is A Duplicate 
					for(int j = 0; j < evenArrayIndexAndSize; j++) {
						if( currentNumber == evenIntArray[j]) {
							duplicateValue = true;
						}//If
					}//For
					
					if (!duplicateValue) {
						evenIntArray[evenArrayIndexAndSize] = currentNumber;
						evenArrayIndexAndSize++;
					}//If
					
				}//If
				
				//Checking If Number Is Odd
				else if(currentNumber % 2 == 1) { 
					//Checking If Number is A Duplicate 
					for(int j = 0; j < oddArrayIndexAndSize; j++) {
						if( currentNumber == oddIntArray[j]) {
							duplicateValue = true;
						}//If
					}//For
					
					if (!duplicateValue) {
						oddIntArray[oddArrayIndexAndSize] = currentNumber;
						oddArrayIndexAndSize++;
					}//If
				}//Else If
				
		}//While
		
		//Closing Scanner And PrintWriter
		readFile.close();
		outputFile.close();
		
		//Displaying Even And Odd Arrays With Zeros 
		for(int i = 0; i < evenIntArray.length; i++) { //Even 
			
			if (i == 0) {
				System.out.println("\n\nEven Array With Zeros:\n"
						+ "-----------------------");
			}//If
			System.out.printf("\nevenIntArray[%d] = %d", i, evenIntArray[i]);
		}//For
		
		for(int i = 0; i < oddIntArray.length; i++) { //Odd
			
			if (i == 0) {
				System.out.println("\n\nOdd Array With Zeros:\n"
						+ "----------------------");
			}//If
			System.out.printf("\noddIntArray[%d] = %d", i, oddIntArray[i]);
		}//For
		
		//Creating Perfectly Sized Even And Odd Arrays With Coutners Used in Fitering Even and Odds 
		int[] noZerosEvenArray = new int[evenArrayIndexAndSize];
		int[] noZerosOddArray = new int[oddArrayIndexAndSize];
		
		//Filling And Displaing New Even And Odd Arrays
		for(int i = 0; i < noZerosEvenArray.length; i++) { //Even
			
			noZerosEvenArray[i] = evenIntArray[i];
			
			if (i == 0) {
				System.out.println("\n\nEven Array: \n"
						+ "-----------------");	
			}//If
			
			System.out.printf("\nevenArray[%d] = %d", i, noZerosEvenArray[i]);
			
		}//For
		
		for(int i = 0; i < noZerosOddArray.length; i++) { //Odd
			
			noZerosOddArray[i] = oddIntArray[i];
			
			if (i == 0) {
				System.out.println("\n\nOdd Array: \n"
						+ "-----------------");	
			}//If
			
			System.out.printf("\noddArray[%d] = %d", i, noZerosOddArray[i]);
			
		}//For
		
	}//Main
}//Class
