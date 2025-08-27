package Default;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/* Isaiah Hoffer
 * CS1150 (M/W)
 * 12/2/24
 * Assignment 12
 * This code will continue to use objects,methods, and arrays, but it will use inheritance and polymorphism. It will have 
 * a superclass, Animals, and subclasses that are type of animals with their own overridden methods and instance values.
 * 
 */

public class HofferIsaiahAssignment12 {

	public static void main(String[] args) throws IOException {
		
		//Reading Given File 
		File inputFileName = new File("Animals.txt");
		Scanner inputFile = new Scanner(inputFileName);
		
		//Array to hold Aniamals 
		Animal[] animalArray = new Animal[inputFile.nextInt()];
		//System.out.println(animalArray.length);
		
		
		//Loop To Fill Ararry
		for(int i = 0; i < animalArray.length; i++) {
			
			String objType = inputFile.next();
			objType = objType.trim();
			
			String objName = inputFile.next();
			objName = objName.trim();
			
			String objFood = inputFile.next();
			objFood = objFood.trim();
			
			int objWeight = inputFile.nextInt();
			
			int objSleep = inputFile.nextInt();

			String objLocation = inputFile.nextLine();
			objLocation = objLocation.trim();
			
			//Checking Object Type 
			switch(objType) {
			case "Bear":
				animalArray[i] = new Bear(objName, objFood, objWeight, objSleep, objLocation);
				break;
			case "Elephant":
				animalArray[i] = new Elephant(objName, objFood, objWeight, objSleep, objLocation);
				break;
			case "Monkey":
				animalArray[i] = new Monkey(objName, objFood, objWeight, objSleep, objLocation);
				break;
			case "Sloth":
				animalArray[i] = new Sloth(objName, objFood, objWeight, objSleep, objLocation);
				break;
			}
			
		}//For
		
		//Displaying animalArray
		for(int i = 0; i < animalArray.length; i++) {
			
			String instance = "";
			
			//Finding Object Name
			if(animalArray[i] instanceof Bear) {
				instance = "Bear";
			}
			else if(animalArray[i] instanceof Elephant) {
				instance = "Elephant";
			}
			else if(animalArray[i] instanceof Monkey) {
				instance = "Moneky";
			}
			else if(animalArray[i] instanceof Sloth) {
				instance = "Sloth";
			}	
	
			//Displaying Info
			System.out.println("Animal["+i+"] is a " + instance);
			System.out.println(animalArray[i].toString());
			animalArray[i].eat();
			animalArray[i].sleep();
			animalArray[i].swim();
			System.out.println();
		}
		
	}//main

}//Class

class Animal {
	
	//Initalizing Values
	private String name;
	private String food;
	private int weight;
	private int sleep;
	private String location;
	
	
	public Animal() {
		
	}//Animal
	
	
	public Animal(String name, String food, int weight, int sleep, String location) {
		
		//Setting Values 
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
		
	}//Animal 
	
	//Getter to get name
	public String getName() {
		
		return name;
	}//getName
	
	//Getter to get food
	public String getFood() {
		
		return food;
	}//getFood
	
	//Getter to get weight
	public int getWeight() {
		
		return weight;
	}//getWeight
	
	//Getter to get sleep
	public int getSleep() {
		
		return sleep;
	}//getSleep
	
	//Getter to get Location
	public String getLocation() {
	
		return location;
	}//getLocation
	
	//Display eating
	public void eat() {
		
		System.out.println("Animal is eating");
	}//eat
	
	//Display sleeping
	public void sleep() {
			
		System.out.println("Animal is sleeping - do not disturb");
	}//eat
		
	//Display swiming
	public void swim() {
			
		System.out.println("Animal is swiming");
	}//eat
	
	//Creates a String about the animal 
	public String toString() {
		
		String animalProfile = "Animal: Name: " + getName() + " - Weighs: " + getWeight() + " lbs - Sleeps: "
							  + getSleep() + " hours - Location: " + getLocation();
		
		return animalProfile;
	}
	
}//Animal class


class Bear extends Animal {
	
	public Bear(String name, String food, int weight, int sleep, String location) {
		
		super(name, food, weight, sleep, location);
		
	}//Bear
	
	@Override
	public void swim() {
		
		System.out.println("Bear is swiming");
	}
	
	@Override
	public void eat() {
		
		System.out.println("Bear is eating " + super.getFood());
	}
	
	@Override
	public void sleep() {
		
		System.out.println("Bear is sleeping for " + super.getSleep() +" hours");
	}
	
	@Override
	public String toString() {
		
		String animalProfile = "Bear: Name: " + super.getName() + " - Weighs: " + super.getWeight() + " lbs - Sleeps: "
							  + super.getSleep() + " hours - Location: " + super.getLocation();
		
		return animalProfile;
	}
	
}//Bear Class

class Elephant extends Animal {
	
	public Elephant(String name, String food, int weight, int sleep, String location) {
		
		super(name, food, weight, sleep, location);
		
	}//Elephant
	
	@Override
	public void swim() {
		
		System.out.println("Elephant is swiming");
	}
	
	@Override
	public void sleep() {
		
		System.out.println("Elephant is sleeping for " + super.getSleep() + " hours");
	}
	
	@Override
	public String toString() {
		
		String animalProfile = "Elephant: Name: " + super.getName() + " - Weighs: " + super.getWeight() + " lbs - Sleeps: "
							  + super.getSleep() + " hours - Location: " + super.getLocation();
		
		return animalProfile;
	}
	
	
}//Elephant class

class Monkey extends Animal {
	
	public Monkey(String name, String food, int weight, int sleep, String location) {
		
		super(name, food, weight, sleep, location);
		
	}//Monkey
	
	@Override
	public void swim() {
		
		System.out.println("Monkey is swiming");
	}
	
	@Override
	public void eat() {
		
		System.out.println("Monkey is eating " + super.getFood());
	}
	
	@Override
	public String toString() {
		
		String animalProfile = "Monkey: Name: " + super.getName() + " - Weighs: " + super.getWeight() + " lbs - Sleeps: "
							  + super.getSleep() + " hours - Location: " + super.getLocation();
		
		return animalProfile;
	}
	
	
}//Monkey class

class Sloth extends Animal {
	
	public Sloth(String name, String food, int weight, int sleep, String location) {
		
		super(name, food, weight, sleep, location);
		
	}//Sloth
	
	@Override
	public String toString() {
		
		String animalProfile = "Sloth: Name: " + super.getName() + " - Weighs: " + super.getWeight() + " lbs - Sleeps: "
							  + super.getSleep() + " hours - Location: " + super.getLocation();
		
		return animalProfile;
	}
	
}//Sloth Class