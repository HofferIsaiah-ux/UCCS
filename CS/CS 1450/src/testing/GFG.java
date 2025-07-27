// Java Program to Illustrate remove() Method
// of PriorityQueue class
// Where Elements are of Integer type
 
// Importing required classes
package testing;

import java.util.*;
 
// Main class
// PriorityQueueDemo
public class GFG {
 
    // Main driver method
    public static void main(String args[])
    {
 
        // Creating an empty PriorityQueue by
        // creating an object of integer type
        Practice queue
            = new Practice();
 
        // Adding custom input elements
        // using add() method
        queue.add(10);
        queue.add(1);
        queue.add(5);
        queue.add(20);
        queue.add(30);
 
        // Displaying the PriorityQueue
        System.out.println("Initial PriorityQueue: "
                           + queue);
 
        // Removing elements from the PriorityQueue
        // using remove() method
       queue.remove();
       queue.remove();
 
        // Displaying the PriorityQueue elements
        // after removal
        System.out.println("PriorityQueue after removing "
                           + "elements: " + queue);
    }
}

class Practice implements Comparable<Integer> {

	@Override
	public int compareTo(Integer o) {
		
		
		
		
	}
	
}