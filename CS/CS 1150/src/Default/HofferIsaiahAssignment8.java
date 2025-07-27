package Default;
import java.util.*;
/* Isaiah Hoffer
 * CS1150 (M/W)
 * 10/30/24
 * Assignment 8
 * This code will start to use methods. It will take a create array and compute the sum and average of different 
 * even numbers and display them to the console. It will also introduce me to objects.
 */
public class HofferIsaiahAssignment8 {
	public static void main(String[] args) {
		
		//Initializing Array of 10
		int[] evenNumberArray= new int[10];
		
		//Setting array values 
		for(int i = 0; i < evenNumberArray.length; i++ ) {
			evenNumberArray[i] = 0 + i*2;
		}//For
		
		//Display was array this is 
		System.out.println("Original Array\n----------------------------------");
		
		//Calling Display Method 
		display(evenNumberArray);
		
		//Calling computeSum Method 
		int sumOfArray = computeSum(evenNumberArray);
		
		//Displaying result of computeSum
		System.out.printf("The Sum of this array is: %d\n", sumOfArray);
		
		//Calling computeAverage Method
		double averageOfArray = computeAverage(evenNumberArray);
		
		//Displaying result of computeAverage 
		System.out.printf("The Average of this array is: %3.2f\n", averageOfArray);
		
		/*-----------------------------------------------------------------
		 *			 Repeat with array incremented by 20
		 * -------------------------------------------------------------	 
		 */
		
		//Variable to increase array values 
		int updateBy20 = 20;
		
		//Calling update
		update(evenNumberArray, updateBy20);

		//Displaying what array this is 
		System.out.println("\nArray incremented by 20\n----------------------------------");
		
		//Calling Display Method 
		display(evenNumberArray);
		
		//Calling computeSum Method 
		int sumOfArrayPlus20 = computeSum(evenNumberArray);
				
		//Displaying result of computeSum
		System.out.printf("The Sum of this array is: %d\n", sumOfArrayPlus20);
				
		//Calling computeAverage Method
		double averageOfArrayPlus20 = computeAverage(evenNumberArray);
				
		//Displaying result of computeAverage 
		System.out.printf("The Average of this array is: %3.2f\n", averageOfArrayPlus20);
		
		/*-----------------------------------------------------------------
		 *			 Repeat with array incremented by 200
		 * -------------------------------------------------------------	 
		 */
		
		//Variable to increase array values 
		int updateBy200 = 200;
		
		//Calling update
		update(evenNumberArray, updateBy200);

		//Displaying what array this is 
		System.out.println("\nArray incremented by 200\n----------------------------------");
		
		//Calling Display Method 
		display(evenNumberArray);
		
		//Calling computeSum Method 
		int sumOfArrayPlus220 = computeSum(evenNumberArray);
				
		//Displaying result of computeSum
		System.out.printf("The Sum of this array is: %d\n", sumOfArrayPlus220);
				
		//Calling computeAverage Method
		double averageOfArrayPlus220 = computeAverage(evenNumberArray);
				
		//Displaying result of computeAverage 
		System.out.printf("The Average of this array is: %3.2f\n", averageOfArrayPlus220);
		
		/*-----------------------------------------------------------------
		 *			 Repeat with array decremented by 220
		 * -------------------------------------------------------------	 
		 */
		
		//Variable to increase array values 
		int updateByMinus220 = -220;
		
		//Calling update
		update(evenNumberArray, updateByMinus220);

		//Displaying what array this is 
		System.out.println("\nArray decremented  by 220\n----------------------------------");
		
		//Calling Display Method 
		display(evenNumberArray);
		
		//Calling computeSum Method 
		int sumOfArrayMinus220 = computeSum(evenNumberArray);
				
		//Displaying result of computeSum
		System.out.printf("The Sum of this array is: %d\n", sumOfArrayMinus220);
				
		//Calling computeAverage Method
		double averageOfArrayMinus220 = computeAverage(evenNumberArray);
				
		//Displaying result of computeAverage 
		System.out.printf("The Average of this array is: %3.2f\n", averageOfArrayMinus220);
		
		//Dog Objects 
		Dog[] dogArray = new Dog[5];
		
		//Setting dog variables 
		Dog dogOne = new Dog("Rover","woof woof");
		Dog dogTwo = new Dog("Max","arf arf arf");
		Dog dogThree = new Dog("Tiny","yap yap yap");
		Dog dogFour = new Dog("Trooper","ruff ruff ruff");
		Dog dogFive = new Dog("Magoo","bow wow bow wow");
		
		//Setting dogArray Values
		dogArray[0] = dogOne;
		dogArray[1] = dogTwo;
		dogArray[2] = dogThree;
		dogArray[3] = dogFour;
		dogArray[4] = dogFive;
		
		makeDogsBark(dogArray);
		
	}//Main
	
	//Find the sum of the Array
	public static int computeSum(int[] numbers) {
		//Initializing arraySum 
		int arraySum = 0;
		
		//Adding all array Values to arraySum
		for(int i = 0; i < numbers.length; i++) {
			arraySum = arraySum + numbers[i];
		}//For
		
		return arraySum;
	}//computeNumbers	
	
	//Finding average of the Array
	public static double computeAverage(int[] numbers) {
		double arrayAverage = 0.0;
		
		//Adding all value in Array and dividing by Array length to arrayAverage 
		for(int i = 0; i < numbers.length; i++) {
			arrayAverage = arrayAverage + numbers[i];
		}
		arrayAverage = arrayAverage / numbers.length;
		
		return arrayAverage;
	}//computeAverage 
	
	
	//Adding updateBy to each array Value 
	public static void update(int[] numbers, int updateBy) {
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = numbers[i] + updateBy;		
		}//For
	}//update 
	
	//Displaying the array values with sum and average  
	public static void display(int[] numbers) {
		
		//Displaying each array Value 
		for(int i = 0; i < numbers.length; i++) {
			System.out.println("numbers["+i+"] = " + numbers[i]);
		}//For 
	}//Display 
	
	//Dog Method 
	public static void makeDogsBark(Dog[] dogArray) {
		
		System.out.println("\n----------------------------------");
		
		//Displaying dog names and sounds 
		for(int i = 0; i < dogArray.length; i++) {
		
			System.out.printf("%s barks like this: %s\n", dogArray[i].getName(), dogArray[i].getBark());
		}//For
		
	}//makeDogsBark
}//Class

class Dog { 
	
	private String name;
	private String bark; 
	
	public Dog(String name, String bark) {
		
			this.name = name;
			this.bark = bark; 
	}//Dog
	
	public String getName() { 
			return name; 
	} //getName
	
	public void setName(String name) {
		
		this.name = name;
	}//setName
	
	public String getBark() {
		
		return bark;
	}//getBark
	
	public void setBark(String bark) {
		
			this.bark = bark;
	}//setBark
}//Dog

