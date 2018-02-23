package classes;
import java.io.*;
import java.util.*;


/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388
 * @class IOHandler: handles all input and output
 */
public class IOHandler {
	
	private Scanner s;
	
	/**
	 * Initializes Scanner s to open a file
	 * @param fileName Name of the file to be opened
	 * @throws IOException When such file does not exist
	 */
	public void openFile(String fileName) throws IOException{
		try{
			s = new Scanner(new File(fileName));
		} catch(IOException e){
			System.out.println("File not found: "+e);
		}
	}
	/**
	 * Reads the name of a file, if any, from file "input.txt".
	 * @return Name of the file in "input.txt" that contains the list of Customers for a new case
	 */
	public String readInputFile(){
			return (String) s.next();	
	}
	/**
	 * Reads file that contains list of customers for a new case, construct a new Customer and adds it to the simulations
	 * @throws Exception when input format is invalid
	 */
	public void readCustomerFile() throws Exception{
		try {
			while(s.hasNext()){
				String customerInfoLine = s.nextLine();
				String[] customerInfo = customerInfoLine.split(",");
				int turn;
				if(customerInfo[0].contains("﻿"))
					turn = Integer.parseInt(customerInfo[0].substring(3));
				else
					turn = Integer.parseInt(customerInfo[0]);
				String ID = customerInfo[1];
				int prepTime = Integer.parseInt(customerInfo[2]);
				double cost;
				if(customerInfo[3].contains("$"))
					cost = Double.parseDouble(customerInfo[3].substring(1));
				else 
					cost = Double.parseDouble(customerInfo[3]);
				int patience = Integer.parseInt(customerInfo[4]);
	
				Restaurant.addToSimulations(new Customer(turn, ID, prepTime, cost, patience));
			}
		}catch(Exception e) {
			System.out.println("Invalid input format: "+e);
		}
	}
	/**
	 * Writes simulation results in a ".out" file with the same name as the input file
	 * @param fileName Name of the input file
	 * @param profit Array containing all profit values for the different approaches
	 * @param customers Array containing all numbers of Customers for different approaches
	 * @throws IOException When there is an error while writing in file
	 */
	public void writeResults(String fileName, double[] profit, int[] customers) throws IOException{
		String file = fileName.substring(0, fileName.length()-4) + ".out";
		try {
			PrintWriter w = new PrintWriter(file);
			w.printf("Maximum profit possible: $%.2f", profit[0]);
			w.println();
			w.printf("Maximum number of customers served possible: %d", customers[0]);
			w.println();
			w.printf("Pat's approach profit: $%.2f", profit[1]);
			w.println();
			w.printf("Pat's approach number of disappointed customers: %d", customers[1]);
			w.println();
			w.printf("Mat's approach profit: $%.2f", profit[2]);
			w.println();
			w.printf("Mat's approach number of disappointed customers: %d", customers[2]);
			w.println();
			w.printf("Max's approach profit: $%.2f", profit[3]);
			w.println();
			w.printf("Max's approach number of disappointed customers: %d", customers[3]);
			w.println();
			w.printf("Pac's approach profit: $%.2f", profit[4]);
			w.println();
			w.printf("Pac's approach number of disappointed customers: %d", customers[4]);
			w.close();
		}catch(IOException e) {
			System.out.println("There was an error while writing in file "+file);
		}
	}
	/**
	 * Allows to close file from another class
	 */
	public void closeFile(){
		s.close();
	}
	/**
	 * Allows to check if scanner hasNext from another class
	 * @return True if the scanner has next value, false otherwise
	 */
	public boolean hasNext(){
		return s.hasNext();
	}
}
