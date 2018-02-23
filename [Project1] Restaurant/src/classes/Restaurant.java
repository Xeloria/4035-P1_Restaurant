package classes;

import simulations.*;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @class Restaurant: Main class. Handles IOHandler and Simulations
 */
public class Restaurant {
	
	private static PAT pat;
	private static MAT mat;
	private static MAX max;
	private static PAC pac;
	private static IOHandler inputReader, csvIO;
	private static String inputFileName = "input.txt";
	private static int numCustomers;
	private static double maxProfitPossible;
	
	/**
	 * Main method
	 * Handles the IOHandler and Simulations
	 * @param args
	 */
	public static void main(String[] args){
		inputReader = new IOHandler();
		try{
			inputReader.openFile(inputFileName);
			String csvFileName;
			while(inputReader.hasNext()){
				csvFileName = inputReader.readInputFile();
				csvIO = new IOHandler();
				csvIO.openFile(csvFileName);
				newCase();
				do{
					csvIO.readCustomerFile();
				}while(csvIO.hasNext());
				csvIO.closeFile();
				
//				RUN SIMULATIONS
				pat.simulate();
				mat.simulate();
				max.simulate();
				pac.simulate();
				
//				WRITE RESULTS IN OUTPUT TEXT FILE
				int[] rCustomers = new int[5];
				double[] rProfit = new double[5];
				rProfit[0] = maxProfitPossible;
				rCustomers[0] = numCustomers;
				rProfit[1] = pat.getProfit();
				rCustomers[1] = pat.getMadCust();
				rProfit[2] = mat.getProfit();
				rCustomers[2] = mat.getMadCust();
				rProfit[3] = max.getProfit();
				rCustomers[3] = max.getMadCust();
				rProfit[4] = pac.getProfit();
				rCustomers[4] = pac.getMadCust();
				
				csvIO.writeResults(csvFileName, rProfit, rCustomers);
				
//				CLEAR PAT, MAT, MAX, PAC
				clearCase();
			}
			inputReader.closeFile();
		} catch(Exception e) {
			System.out.println("Exception : "+e);
		}
	}
	
	/**
	 * Prepares and initializes simulations for a new input case
	 */
	public static void newCase(){
		pat = new PAT();
		mat = new MAT();
		max = new MAX();
		pac = new PAC();
		numCustomers = 0;
		maxProfitPossible = 0;
	}
	
	/**
	 * Calls the clear methods from simulations to help the Garbarge Collector
	 */
	public static void clearCase() {
		pat.clear();
		mat.clear();
		max.clear();
		pac.clear();
	}
	
	/**
	 * Add Customers to the simulations and calculates:
	 * Maximum profit possible
	 * Maximum number of customers served possible
	 * @param c  Customer to be added
	 */
	public static void addToSimulations(Customer c) {
		pat.addCustomers(c);
		mat.addCustomers(c);
		max.addCustomers(c);
		pac.addCustomers(c);
		numCustomers++;
		maxProfitPossible += c.cost();
	}
}