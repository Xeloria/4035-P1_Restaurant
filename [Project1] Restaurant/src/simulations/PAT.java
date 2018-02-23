package simulations;

import classes.Customer;
import collections.SLLQueue;
import interfaces.Simulation;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @class PAT: Pat's approach, First-In-First-Out
 */
public class PAT implements Simulation<Customer> {
	
	private static double profit;
	private static int  unhappyC;
	private static SLLQueue<Customer> cQ;
	
	/**
	 * Constructor for PAT
	 */
	public PAT() {
		cQ = new SLLQueue<Customer>();
		profit = 0;
		unhappyC = 0;
	}
	
	/**
	 * Run simulation for Pat's approach
	 */
	public void simulate() {
		int t=0;
		while((!cQ.isEmpty())){	
			if(cQ.first().arrival()<=t) {
				if((cQ.first().patience()+cQ.first().arrival())<t) {
					cQ.dequeue();
					unhappyC++;
				} else if((!cQ.isEmpty())&&(cQ.first().arrival()<=t) 
						&& !((cQ.first().patience()+cQ.first().arrival())<t))  {
					t+=cQ.first().prepTime();
					profit+=cQ.first().cost();
					cQ.dequeue();
				} else
					t++;
			} else 
				t++;
		}
	}
	
	/**
	 * @return Profit generate by Pat's approach
	 */
	public double getProfit() {
		return profit;
	}
	
	/**
	 * @return Number of disappointed Customers
	 */
	public int getMadCust() {
		return unhappyC;
	}
	
	/**
	 * @param c Customer to be added in the simulation
	 */
	public void addCustomers(Customer c) {
		cQ.enqueue(c);
	}
	
	/*
	 * Clear data structures used in the simulation to help Garbage Collector
	 */
	public void clear() {
		cQ.clear();
	}

}
