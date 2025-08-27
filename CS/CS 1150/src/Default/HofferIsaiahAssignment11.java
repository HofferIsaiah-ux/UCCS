package Default;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/* Isaiah Hoffer
 * CS1150 (M/W)
 * 12/1/24
 * Assignment 11
 * This code will continue to use objects,methods, and arrays. It will create car objects
 * and simulate a simple driving simulation.
 */
public class HofferIsaiahAssignment11 {

	public static void main(String[] args) throws IOException  {
		
		//Create Car Object Array
		Car[] carObjArray = new Car[5];
		
		//Calling createCars Method 
		createCars(carObjArray);
		
		//Calling wrtieCarDetailsToFile 
		writeCarDetailsToFile(carObjArray);
		
		//Pretext 
		System.out.printf("Cars At Start Of Simulation\n"
				+ "------------------------------------------------------------------------------------------\n"
				+ "Owner\t\t\tVehicle\t\t\tMPG\t\tGallons\t\tMileage\n"
				+ "------------------------------------------------------------------------------------------\n");
		
		//Calling printCars Method
		printCars(carObjArray);
		
		//Pretext
		System.out.println("\n\nAll Cars Are Ready - Start The Simulation\n");
		
		//Calling simulation Method
		simulation(carObjArray);
		
		//Pretext 
		System.out.printf("\nCars At End Of Simulation\n"
				+ "------------------------------------------------------------------------------------------\n"
				+ "Owner\t\t\tVehicle\t\t\tMPG\t\tGallons\t\tMileage\n"
				+ "------------------------------------------------------------------------------------------\n");
		//Calling createCars Method 
		printCars(carObjArray);
		
		
	}//Main

	// Creates Car Objects 
	public static void createCars(Car[] cars) {
		
		cars[0] = new Car("Donkey", "Toyota Tundra", 15, 34000, 8);
		cars[1] = new Car("Fiona", "Audi Q7", 21, 7110, 10);
		cars[2] = new Car("Shrek", "Jeep CJ5", 14, 11800, 5);
		cars[3] = new Car("Farquaad", "Smart Car", 42, 82700, 4);
		cars[4] = new Car("Dragon", "Chevy Suburban", 12, 150245, 30);
		
	}//createCars Method 
	
	public static void printCars(Car[] cars) {
		
		for(int i = 0; i < cars.length; i++) {
			
			System.out.printf("%8s\t  %14s\t\t%3.2f\t\t%3.2f\t\t%8.2f\n",
					cars[i].getOwner(),cars[i].getModel(),cars[i].getMilesPerGallon(),
					cars[i].getFuelGauge().getGallons(),cars[i].getOdometer().getMileage());
			
			
		}//For
		
	}//printCars
	
	//Checking if all Cars are Empty
	public static boolean checkFuelLevels(Car[] cars) {
		
		//Variable to counter Empty Cars
		int carIsEmpty = 0;
		
		for(int i = 0; i < cars.length; i++) {
			
			
			if(cars[i].getFuelLevel().equalsIgnoreCase("Empty")) {
				carIsEmpty++;
			}
			
			if(carIsEmpty == cars.length) {
				return true;
			}
			
		}//For
		
		return false;
		
	}//checkFuelLevels
	
	
	public static void simulation(Car[] cars) {
		
		//Array For Empty Cars
		Car[] emptyCarObjArray = new Car[5];
		
		//Variable to iterate through new array
		int emptyCarArrayIndex = 0;
		
		//Variable to end while loop  
		boolean allCarsAreEmpty = false;
		
		//Iteration Miles Constant
		final int MILES_PER_ITERATION = 25;
		
		
		while(!allCarsAreEmpty) {
			
			for(int i = 0; i < cars.length; i++) {
				//Checking if car has gas 
				if(cars[i].getFuelLevel().equalsIgnoreCase("Has Gas")) {
					
					//Variable to check if Car has enough Gas
					double gallonsNeededForIteration = MILES_PER_ITERATION / cars[i].getMilesPerGallon();
					double currentNumberOfGallons = cars[i].getFuelGauge().getGallons();
					
					if(currentNumberOfGallons >= gallonsNeededForIteration) {
						
						//Updating Cars current gallons 
						cars[i].getFuelGauge().decrementGallons(gallonsNeededForIteration);
						
						//Updating Cars Odometer
						cars[i].getOdometer().updateMiles(MILES_PER_ITERATION);
						
					}//If
					else {
						
						emptyCarObjArray[emptyCarArrayIndex] = cars[i];
						
						//Changing Cars Fuel Level to Empty 
						cars[i].setFuelLevel();
						
						emptyCarArrayIndex++;
						
					}//Else
					
				}//If
				
			}//For
			
			allCarsAreEmpty = checkFuelLevels(cars);
			
		}//While
		
		//More Pretext
		System.out.println("The Cars Ran Out Of Gas In this Order: \n"
				+ "-----------------------------------------------");
		
		//Displaying Cars
		for(int i = 0; i < cars.length; i++) {
			
			System.out.printf("Ran Out Of Gas: %s\n",emptyCarObjArray[i].getOwner());
			
		}//For
		
	}//simulation Method
	
	
	public static void writeCarDetailsToFile(Car[] cars) throws IOException {
		
		//Create File Variable 
		File fileName = new File("Assignment11.txt");
		
		//Create File 
		PrintWriter resultsFile = new PrintWriter(fileName);
		
		//Write text to file 
		resultsFile.println("Car Details");
		for(int i = 0; i < cars.length; i++) {
			
			resultsFile.println(cars[i].getOwner());
			resultsFile.println(cars[i].getModel());
			resultsFile.println(cars[i].getMilesPerGallon());
			resultsFile.println(cars[i].getFuelGauge().getGallons());
			resultsFile.println();
			
			
		}//For
		
		resultsFile.close();
		
		//Displaying File Locating 
		System.out.println("Find The File Here: " + fileName.getAbsolutePath());
		System.out.println();
		
		
	}//writeCarDetailsToFile Class 
	
}//Class

class Car {
	
	//Initializing Variables 
	private String owner;
	private String model;
	private String fuelLevel = "Has Gas";
	private double milesPerGallon;
	private Odometer odometerObj;
	private FuelGauge fuelGaugeObj; 
	
	public Car(String owner, String model, double milesPerGallon, 
			   double currentMileage, double currentGallons) {
		
		this.owner = owner; 
		this.model = model; 
		this.milesPerGallon = milesPerGallon; 
		
		this.odometerObj = new Odometer(currentMileage); 
		this.fuelGaugeObj = new FuelGauge(currentGallons); 
		
		
	}//Car Constructor
	
	//Getter to get Owner 
	public String getOwner() {
		
		return owner;
	}//getOwner Method
	
	//Getter to get Model
	public String getModel() {
		
		return model; 
	}//getModel Method 
	
	//Getter to get Miles Per Gallon 
	public double getMilesPerGallon() {
		
		return milesPerGallon;
	}//getMilesPerGallon Method
	
	//Getter to get Odometer Object
	public Odometer getOdometer() {
		
		return odometerObj;
	}//getOdometer Method 
	
	//Getter to get Fuel Gauge Object
	public FuelGauge getFuelGauge() {
		
		return fuelGaugeObj;
	}//getFuelGauge Method
	
	//Getter to get Fuel level
	public String getFuelLevel() {
		
		return fuelLevel;
	}//getFeulLevel Method 
	
	
	//Setter to set Fuel Level to "Has Gas"
	public void setFuelLevel() {
		
		fuelLevel = "Empty";
	}//setFuelLevel
	
	
}//Car class

//Represents Cars Fuel Gauge 
class FuelGauge {
	
	private double gallons;
	
	public FuelGauge(double gallons) {
		
		this.gallons = gallons;
	}
	
	//Getters to get Gallons 
	public double getGallons() {
		
		return gallons;
	}//getGallons Method 
	
	//Method to decrease gallons used 
	public void decrementGallons(Double gallonsUsed) {
		
		if(this.gallons >= gallonsUsed) {
			
			gallons = gallons - gallonsUsed;
			
		}//If
		else {
			gallons = 0;
		}
		
	}//decrementGallons Method
	
}
//Represents Car's Odometer
class Odometer {
	
	private double mileage;
	
	public Odometer(double mileage) {
	
		this.mileage = mileage;
	}
	
	//Getter to get Mileage
	public double getMileage() {
		
		return mileage;
	}//getMileage Method
	
	public void updateMiles(double milesTraveled) {
		
		mileage = mileage + milesTraveled; 
		
	}//updateMiles Method
	
}//Odometer Class

