package Default;
import java.util.*;
/* Isaiah Hoffer
 * CS1150 (M/W)
 * 9/9/24
 * Assignment 2
 * This code will introduce user input. Taking those values and using math equations to find the wind chill of 
 * different places using temperature in both Fahrenheit and Celsius and wind speed and will give the differences between 
 * the 2 places. 
*/

public class HofferIsaiahAssignment2 {
	public static void main(String[] args) {
		//Create a constant WIND_EXPONENT 
		final Double WIND_EXPONENT = 0.16;
		
		//Make a Scanner scanner  
		Scanner input = new Scanner(System.in); 
		
		//Print/Ask user for Location, Wind Speed in mph, Temperature in Fahrenheit  
		//Use locationOne, windSpeedOne, tempFOne for location 1  
		System.out.println("Location One Information: \n"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("What is the name of the 1st Location (No Spaces): ");
		String locationOne = input.next(); // Setting the first location to locationOne
		System.out.println("How fast in the wind going in " + locationOne + " (MPH): ");
		Double windSpeedOne = input.nextDouble(); // Setting wind speed in locationOne to windspeedOne
		System.out.println("What's the Temperature (F) in " + locationOne + ": ");
		Double tempFOne = input.nextDouble(); // Setting the temperature (F) in locationOne to tempFOne
		
		//Same thing for location 2, different variables
		System.out.println("Location Two Information: \n"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("What is the name of the 2nd Location (No Spaces): ");
		String locationTwo = input.next(); // Setting the second location to locationTwo
		System.out.println("How fast in the wind going in " + locationTwo + " (MPH): ");
		Double windSpeedTwo = input.nextDouble(); // Setting wind speed in locationTwo to windspeedTwo
		System.out.println("What's the Temperature (F) in " + locationTwo + ": ");
		Double tempFTwo = input.nextDouble(); // Setting the temperature (F) in locationTwo to tempFTwo

		//Calculate Temp into Celsius, into tempCOne and tempCTwo 
		Double tempCOne = (tempFOne - 32) * (double) 5/9;
		Double tempCTwo = (tempFTwo - 32) * (double) 5/9;
		
		//Calculate Wind Chill , named windChillFOne
		Double windChillFOne = 35.74 + 0.6215 * tempFOne - 35.75 * Math.pow(windSpeedOne,WIND_EXPONENT) + 0.4275 * tempFOne * Math.pow(windSpeedOne,WIND_EXPONENT);
			
		//Repeat for tempFTwo, windSpeedTwo, named windChillFTwo 
		Double windChillFTwo = 35.74 + 0.6215 * tempFTwo - 35.75 * Math.pow(windSpeedTwo,WIND_EXPONENT) + 0.4275 * tempFTwo * Math.pow(windSpeedTwo,WIND_EXPONENT);
		
		// Use F to C to find wind chill in Celsius
		Double windChillCOne = (windChillFOne - 32) * (double) 5/9;
		Double windChillCTwo = (windChillFTwo - 32) * (double) 5/9;

		//Table for each locations  
		System.out.println("_______________________________________________________________________________________________________________________ \n\n"
				+ "\t\t\t\t\t\t   WIND CHILL CALCULATOR   \t\t\t\t\t\t\n"
				+ "_______________________________________________________________________________________________________________________");
		System.out.println("Location \t Wind Speed \t Temperature (F) \t Wind Chill (F) \t Temperature (C) \t Wind Chill (C)");
		
		// Location 1
		System.out.printf("%s  ",locationOne);
		System.out.printf("\t%6.2f",windSpeedOne);
		System.out.printf("\t\t%6.2f", tempFOne);
		System.out.printf("\t\t\t%6.2f",windChillFOne);
		System.out.printf("\t\t\t%6.2f",tempCOne);
		System.out.printf("\t\t\t\t%6.2f",windChillCOne);
		
		// Location 2
		System.out.printf("\n%s  ",locationTwo);
		System.out.printf("\t%6.2f",windSpeedTwo);
		System.out.printf("\t\t%6.2f", tempFTwo);
		System.out.printf("\t\t\t%6.2f",windChillFTwo);
		System.out.printf("\t\t\t%6.2f",tempCTwo);
		System.out.printf("\t\t\t\t%6.2f",windChillCTwo);
		
		//Table for the differences between the two locations  
		System.out.printf("\n%s  ","Differences: ");
		System.out.printf("\t%6.2f",windSpeedOne - windSpeedTwo);
		System.out.printf("\t\t%6.2f",tempFOne - tempFTwo);
		System.out.printf("\t\t\t%6.2f",windChillFOne - windChillFTwo);
		System.out.printf("\t\t\t%6.2f",tempCOne - tempCTwo);
		System.out.printf("\t\t\t\t%6.2f",windChillCOne - windChillCTwo);
	}

}
