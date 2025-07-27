package Assignment6;
// CS1450 Assignment #6 Spring 2025
// Worksheet #3: Complicated Nested Objects
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.Queue;

public class Worksheet3_Spring2025 {

	public static void main(String[] args) {
		
		//**********************************
		// Worksheet3 Cargo Terminal Setup 
		//**********************************
		// I'm going to build a cargo terminal and fill it with a bunch of planes by HARD CODING!
		// I'm doing this to test the code.
		
		// Create a cargo terminal object that contains a tarmac.
		// Remember the tarmac is an array and each slot represents a parking spot (stand) for a plane
		// The tarmac here will have 6 stands (0-5)
		// This cargo terminal does not have a loading dock.
		int numberStands = 6;
		CargoTerminalW3 cargoTerminal = new CargoTerminalW3(numberStands);

		System.out.println();
		System.out.println("Hard coding 3 planes to test code");
		System.out.println("---------------------------------");
		System.out.println("Flight 817 contains 1 containers");
		System.out.println("Flight 444 contains 4 containers");
		System.out.println("Flight 245 contains 2 containers");
		System.out.println();

		// Hard code 3 planes - hard coding is the way to go when doing this type of testing!
		// Of course we would not do this in an assignment!  I'm doing it for testing purposes.
		PlaneW3 flight817 = new PlaneW3("Flight 817", 180000);  
		PlaneW3 flight444 = new PlaneW3("Flight 444", 60000);    
		PlaneW3 flight245 = new PlaneW3("Flight 245", 120000);    

		// Add planes to cargo terminal - hard coding the stand number for quick setup.
		// Of course we would not do this in a regular assignment - this is just for testing purposes
		cargoTerminal.addCargoPlane(0, flight817);
		cargoTerminal.addCargoPlane(3, flight444);
		cargoTerminal.addCargoPlane(5, flight245);
		
		// Add some containers to each plane	
		// Create some containers and add them to flight 817 that is parked in stand 0
		cargoTerminal.addContainerToPlane(new ContainerW3("AP12345"), 0);

		// Create some containers and add them to flight 444 parked in stand 3
		cargoTerminal.addContainerToPlane(new ContainerW3("AP3321"), 3);
		cargoTerminal.addContainerToPlane(new ContainerW3("AP3354"), 3);
		cargoTerminal.addContainerToPlane(new ContainerW3("AP3322"), 3);
		cargoTerminal.addContainerToPlane(new ContainerW3("AP3378"), 3);

		// Create some containers and add them to flight 245 parked in stand 5
		cargoTerminal.addContainerToPlane(new ContainerW3("AP5534"), 5);
		cargoTerminal.addContainerToPlane(new ContainerW3("AP245464"), 5);

		// Now the cargo terminal is setup with planes and each plane has a queue of "containers"
		// Display some information to test the code 
		for (int stand = 0; stand < numberStands; stand++) {
			
			// Get a plane out of the array (stand = array slot)
			PlaneW3 aPlane = cargoTerminal.getPlane(stand);

			// If there was a plane in the stand (array slot) display the containers in the queue
			if (aPlane != null) {
				
				System.out.print("Plane " + aPlane.getFlightNumber() + " parked in stand " + stand);
				
				// Display number of containers in this plane's queue of containers
				int numContainers = aPlane.getContainersSize();
				System.out.println(" contains " + numContainers + " containers");

				// For each container in the queue, display it's id.  
				// Since the queue is inside the Plane object we first have to use the Plane's 
				// getContainer method to obtain a Container object.  
				// After we have the container, we can then call the Container's getId method.
				for (int i = 0; i < numContainers; i++) {
					System.out.println("Container Id: " + aPlane.removeContainer().getId());
				}
				System.out.println();

			} // tarmac slot (stand) not empty
			else {
				System.out.println("Stand " + stand + "  is empty");
				System.out.println();
			}
			
		} // for each plane on the tarmac

	} //main

} // Worksheet3


class ContainerW3  {
	
	private String id;			
	
	public ContainerW3 (String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
} // Container


//********************************
//Worksheet3 Question #1
//Write the code for each method
//********************************
class PlaneW3 { 
	
	private String flightNumber;
	private double capacity;
	
	private Queue<ContainerW3> containers = new LinkedList<>();  // Queue of containers that  
	 														   	 // will be loaded on plane
		
	// Create a plane
	public PlaneW3 (String flightNumber, double capacity) {
		this.flightNumber = flightNumber;
		this.capacity = capacity;
	}
			
	public String getFlightNumber() {
		return flightNumber;
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	public int getContainersSize() {
		// ADD CODE HERE
		
		return containers.size();
		
	}
	
	public void addContainer(ContainerW3 container) {
		// ADD CODE HERE
		
		containers.offer(container);
	}
	
	public ContainerW3 removeContainer() {
		// ADD CODE HERE
		
		return containers.remove();
	}
		
} // PlaneW3


//Represents the Cargo Terminal - a little different from assignment 4.  
//The cargo terminal contains a tarmac that is modeled using a 1D-array.
//Each location in the tarmac contains a plane object or null. 
class CargoTerminalW3 {
	
	private int numberStands;	// Number of stands (parking locations) for planes
	private PlaneW3[] tarmac;	// Array representing parking spots that hold planes
	
	
	public CargoTerminalW3 (int numberStands) {
		this.numberStands = numberStands;		// Number of stands in the tarmac array
		tarmac = new PlaneW3[numberStands];	// Allocate memory for tarmac
	}

	
	// Add a plane to the plane array in a specific location
	public void addCargoPlane (int stand, PlaneW3 plane) {
		tarmac[stand] = plane; 
	}

	
	// Returns the plane in the specified location in the array.  
	// When a slot does NOT contain a plane return null.
	public PlaneW3 getPlane(int stand) {
		return tarmac[stand];
	}

	
	//********************************
	// Worksheet3 Question #3
	// Add a container to a plane in stand on the tarmac
	//********************************
	public void addContainerToPlane(ContainerW3 container, int stand) {
		// ADD CODE HERE
		
		tarmac[stand].addContainer(container);
	}
		
} // CargoTerminalW3

