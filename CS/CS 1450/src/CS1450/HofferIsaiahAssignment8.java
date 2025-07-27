package cs1450;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/* 
Isaiah Hoffer 
CS1450 (M/W)
4/10/25
Assignment 8
This assignment will take in 3 files. Two files, the messages, have numbers that are indexes for a 2D Array and the keyGrid file gives you the decoding 
message used to figure out what the two messages say. This assignment will use iterators from arraylists and queues. At the end disaply the deciphering key 
and the two messages deciphered.
*/
public class HofferIsaiahAssignment8 {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Creating Files 
		File messageOneFile = new File("Message1.txt");
		File messageTwoFile = new File("Message2.txt");
		File keyGridFile = new File("KeyGrid.txt");
		
		//Opening Files For Reading -- Scanner 
		Scanner readMessageOne = new Scanner(messageOneFile);
		Scanner readMessageTwo = new Scanner(messageTwoFile);
		Scanner readKeyGrid = new Scanner(keyGridFile);
		
		DecodingMachine decodingMachineObj = new DecodingMachine(
											readKeyGrid.nextInt(), readKeyGrid.nextInt());
		
		//Creating ArrayList
		ArrayList<Character> keyGridList = new ArrayList<>();
		
		//Filling ArrayList 
		while(readKeyGrid.hasNext()) {
			
			keyGridList.add(readKeyGrid.next().charAt(0));
			
		}//While
		
		//Creating An Iterator For The ArrayList
		Iterator<Character> keyGridIterator = keyGridList.iterator();
		
		//calling fillKeyGrid Method
		decodingMachineObj.fillKeyGrid(keyGridIterator);
		
		//Displaying Key Grid Used To Decode Method 
		//Pretext
		decodingMachineObj.printKeyGrid();
		
		//Creating Queues To Store Secret Message
		Queue<KeyGridElement> messageOneQueue = new LinkedList<>();
		Queue<KeyGridElement> messageTwoQueue = new LinkedList<>();
		
		fillQueue(messageOneQueue, readMessageOne);
		fillQueue(messageTwoQueue, readMessageTwo);
	
		//Creating Iterators From Queues
		Iterator<KeyGridElement> messageOneIterator = messageOneQueue.iterator();
		Iterator<KeyGridElement> messageTwoIterator = messageTwoQueue.iterator();
		
		//Calling DecodingMessage Method And Store Returned Iterator 
		Iterator<Character> decodedMessageOne = decodingMachineObj.decodeMessage(messageOneIterator);
		Iterator<Character> decodedMessageTwo = decodingMachineObj.decodeMessage(messageTwoIterator);	
		
		//Displaying First Message -- Decoded 
		System.out.printf("\n\nFirst Message Decoded:\n");
		System.out.printf("------------------------------------------------\n");
		while(decodedMessageOne.hasNext()) {
			
			System.out.printf("%c",decodedMessageOne.next());
		}//While
		
		//Displaying First Message -- Decoded 
		System.out.printf("\n\nSecond Message Decoded:\n");
		System.out.printf("------------------------------------------------\n");
		while(decodedMessageTwo.hasNext()) {
					
			System.out.printf("%c",decodedMessageTwo.next());
		}//While
		
		//Closing Scanner 
		readMessageOne.close();
		readMessageTwo.close();
		readKeyGrid.close();
		
	}//main
	
	public static void fillQueue(Queue<KeyGridElement> queue, Scanner messageFile) {
		
		while(messageFile.hasNext()) {
			
			int row = messageFile.nextInt();
			int column = messageFile.nextInt();
			
			queue.offer(new KeyGridElement(row, column));			
		}//While
		
	}//FillQueue Method
}//class

//Finds Location Of A Character From The Key Grid
class KeyGridElement {
	
	//Private Data 
	private int row; //How Many Rows 2D Array Will Have
	private int column; //How Many Columns 2D Array Will Have 
	
	public KeyGridElement(int row, int column) {
		
		//Initalizing Variables 
		this.row = row;
		this.column = column;
		
	}//KeyGridElement Constructor
	
	
	//Getter For Row
	public int getRow() {
		
		return row;
	}//getRow Method 
	
	//Getter For Column
	public int getColumn() {
		
		return column;
	}//getColumn Method
	
}//KeyGridElement Class

//Decode Message From Files 
class DecodingMachine{
	
	char[][] keyGrid;
	int numRows;
	int numColumns;
	
	public DecodingMachine(int numRows, int numColumns) {
		
		//Initalizing Variables 
		this.numRows = numRows;
		this.numColumns = numColumns; 
		
		this.keyGrid = new char[numRows][numColumns]; //2D Array
		
	}//DecodingMachine Constructor 
	
	public void fillKeyGrid(Iterator<Character> charIterator) {
		
		for(int row = 0; row < numRows; row++) {
			
			for(int column = 0; column < numColumns; column++ ) {
					
				keyGrid[row][column] = charIterator.next();
			}//For Column 
		}//For Row
		
	}//FillKeyGrid Method
	
	//Decode Message
	public Iterator<Character> decodeMessage(Iterator<KeyGridElement> msgIterator) {
		
		ArrayList<Character> secretMessage = new ArrayList<>(); 
		
		//Goes Through Message File Indexes, Returns Character At Index Found Within Object 
		while(msgIterator.hasNext()) {
			
			//Gets Next Object To get Indexes From 
			KeyGridElement iterator2DIndex = msgIterator.next();
		
			secretMessage.add(keyGrid[iterator2DIndex.getRow()][iterator2DIndex.getColumn()]);
		}//While
		
		//Changing ArrayList To Iterator
		Iterator<Character> secretMessageIterator = secretMessage.iterator();
		
		return secretMessageIterator;
	}//decodeMessage Method 
	
	//Prints Decoded Message
	public void printKeyGrid() {
		
		//Pretext
		System.out.printf("Decoding Machine's Key Grid: \n");
		System.out.printf("------------------------------------------------");
		
		//Printing Characters From 2D Array
		for(int row = 0; row < numRows; row++) {
			
			System.out.printf("\n"); 
			for(int column = 0; column < numColumns; column++) {
	
				System.out.printf("%c",keyGrid[row][column]);
				
			}//For Column		
			
		}//For Row	
		
	}//printKeyGrid Method
}//DecodingMachine Class


