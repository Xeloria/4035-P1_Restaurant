package simulations;

import classes.Customer;
import collections.*;
import interfaces.Simulation;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @class MAT: Mat's approach, Last-In-First-Out
 */
public class MAT implements Simulation<Customer> {

	private static double profit;
	private static int unhappyC;
	private static SLLQueue<Customer> cQ;
	private static LLStack<Customer> cS;
	
	/**
	 * Constructor for MAT
	 */
	public MAT() {
		cQ = new SLLQueue<Customer>();
		cS = new LLStack<Customer>();
		unhappyC = 0;
		profit = 0;
	}
	
	/**
	 * Run simulation for Mat's approach
	 */
	public void simulate() {
		int t = 0;
		while(!cQ.isEmpty() || !cS.isEmpty()) {
			while((!cQ.isEmpty()) && (cQ.first().arrival() <= t)) {
				cS.push(cQ.dequeue());
			}
			
			if((!cS.isEmpty())&&cS.top().arrival()<=t) {
				if((cS.top().patience()+cS.top().arrival())<t) {
					unhappyC++;
					cS.pop();
				} else if((!cS.isEmpty())&&(cS.top().arrival()<=t) 
						&& !((cS.top().patience()+cS.top().arrival())<t))  {
					t+=cS.top().prepTime();
					profit+=cS.top().cost();
					cS.pop();
				} else
					t++;
			} else 
				t++;
		}	
	}
	
	/**
	 * @return Profit generate by Mat's approach
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
		cS.clear();
	}

}
