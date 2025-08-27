package Default;
import java.util.Arrays;

/* Isaiah Hoffer
 * CS1150 (M/W)
 * 11/5/24
 * Assignment 9
 * This code will continue my practice with arrays using methods/overloaded methods. It will create an 
 * array of numbers and words and do various action towards them. 
 */

public class HofferIsaiahAssignment9 {

	public static void main(String[] args) {
		
		//Creating and Initializing Arrays 
		int[] numbers = {1,5,1,2,6,5,5,4,2,3,3};
		String [] names = {"Noah","Paul","Eli","Brett","Jack","Eli","Noah","Eli","Jack","Paul"};
		
		/*-------------------------------------------------------------------------
		 * 							Integer Array Manipulation 
		 *-------------------------------------------------------------------------
		 */
		
		
		//Pretext for Clarification 
		System.out.println("************************************************\n"
				+ "\t  Manipulating A Numberic Array  \t\n"
				+ "************************************************\n");
		System.out.println("\nOriganal Numberic Array: ");
		
		//Calling printArray Method 
		printArray(numbers);
		
		//Calling eliminateDuplicates Method 
		int[] numbersNoDuplicates = eliminateDuplicates(numbers);
		
		
		//Pretext 
		System.out.println("\nNumberic Array With No Duplicates: ");
		
		//Calling printArray
		printArray(numbersNoDuplicates);
		
		
		//Calling sortArrayMethod 
		sortArray(numbersNoDuplicates);
		
		//Pretext 
		System.out.println("\nNumberic Array Sorted: ");
		
		//Calling printArray Method 
		printArray(numbersNoDuplicates);
		
		/*-------------------------------------------------------------------------
		 * 							String  Array Manipulation 
		 *-------------------------------------------------------------------------
		 */
		

		//Pretext for Clarification 
		System.out.println("************************************************\n"
				+ "\t  Manipulating A String Array  \t\n"
				+ "************************************************");
		System.out.println("\nOriganal String Array: ");
		
		//Calling printArray Method 
		printArray(names);
		
		//Calling eliminateDuplicates Method 
		String[] namesNoDuplicates = eliminateDuplicates(names);
		
		
		//Pretext 
		System.out.println("\nString Array With No Duplicates: ");
		
		//Calling printArray
		printArray(namesNoDuplicates);
		
		
		//Calling sortArrayMethod 
		sortArray(namesNoDuplicates);
		
		//Pretext 
		System.out.println("\nString Array Sorted: ");
		
		//Calling printArray Method 
		printArray(namesNoDuplicates);
		
		
	}//main

	//Prints/Displays integer Arrays 
	public static void printArray(int[] numbers) {
		
		//Loop to index Array and display index 
		for(int i = 0; i < numbers.length; i++) {
			
			//Displaying value 
			System.out.println(numbers[i]);
			
		}//For
		
	}//printArray Integer 
	
	
	//Prints/Displays String Arrays 
	public static void printArray(String[] names) {
		
		//Loop to index Array and display index 
			for(int i = 0; i < names.length; i++) {
					
				//Displaying value 
				System.out.println(names[i]);
			}//For		
		
	}//printArray String 
	
	//Removes All Duplicate Values from Original Array and Returns a New Array 
	public static int[] eliminateDuplicates(int[] numbers) {
		
		//Temporary array to hold values from Numbers 
		int[] tempArray = new int[numbers.length];
		
		//Counter to set numbersNoDuplicates length
		int arrayLengthCounter = 0;
		
		//Loop to check each value from Original Array 
		for (int i = 0; i < numbers.length; i++) {
			
			//Giving values to tempArray 
			tempArray[i] = numbers[i];
			
			//Counter to set numbersNoDuplicates length
			arrayLengthCounter = 0;
			
			//Checking for duplicate values
			for (int j = 0; j < numbers.length; j++) {
				
				//Condition for Duplicate Values 
				if (tempArray[i] == tempArray[j] && j != i) {
					
					//Setting Duplicate Value to 0 
					tempArray[i] = 0;
				}//If 
							
				//Checking how many non-duplicates the array has 
				if (tempArray[j] != 0) {
					
					//Counter for Array Length  
					arrayLengthCounter++;		
				}//If 		
			}//For J	
		}//For I
		
		//Initializing and Setting Values to numbersNoDuplicates 
		int[] numbersNoDuplicates = new int[arrayLengthCounter];
		
		//Counter to get non-zeros 
		int indexCounter = 0;
		
		//Setting Values
		for (int i = 0; i < arrayLengthCounter; i++) {
					
			//Only want non zeros 
			while (tempArray[i + indexCounter] == 0) {
				indexCounter++;
			}
				//Setting Values 
				numbersNoDuplicates[i] = tempArray[i + indexCounter];
		}//For 
		
		//Returning Array with no Duplicates 
		return numbersNoDuplicates;
	}//eliminateDuplicates Integer 
	
	//Removes All Duplicate Values from Original Array and Returns a New Array 
		public static String[] eliminateDuplicates(String[] names) {
			
			//Temporary array to hold values from Names  
			String[] tempArray = new String[names.length];
			
			//Counter to set namesNoDuplicates length
			int arrayLengthCounter = 0;
			
			//Loop to check each value from Original Array 
			for (int i = 0; i < names.length; i++) {
				
				//Giving values to tempArray 
				tempArray[i] = names[i];
				
				//Counter to set namesNoDuplicates length
				arrayLengthCounter = 0;
				
				//Checking for duplicate values
				for (int j = 0; j < names.length; j++) {
					
					//Condition for Duplicate Values 
					if (tempArray[i] == tempArray[j] && j != i) {
						
						//Setting Duplicate Value to null
						tempArray[i] = null;
					}//If 
								
					//Checking how many non-duplicates the array has 
					if (tempArray[j] != null) {
						
						//Counter for Array Length  
						arrayLengthCounter++;		
					}//If 		
				}//For J	
			}//For I
			
			//Initializing and Setting Values to namessNoDuplicates 
			String[] namesNoDuplicates = new String[arrayLengthCounter];
			
			//Counter to get Strings 
			int indexCounter = 0;
			
			//Setting Values
			for (int i = 0; i < arrayLengthCounter; i++) {
						
				//Only want Strings 
				while (tempArray[i + indexCounter].isEmpty()) {
					indexCounter++;
				}
					//Setting Values 
					namesNoDuplicates[i] = tempArray[i + indexCounter];
			}//For 
			
			//Returning Array with no Duplicates 
			return namesNoDuplicates;
		}//eliminateDuplicates String 

		
		//Sorts the Array 
		public static void sortArray(int[] numbers) {
			
			//Sorting Array 
			Arrays.sort(numbers); 
			
		}//sortArray Integer 
		
		//Sorts the Array 
		public static void sortArray(String[] names) {
					
			//Sorting Array 
			Arrays.sort(names); 
					
		}//sortArray String  
		
		
		
		
}
