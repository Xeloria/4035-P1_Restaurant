package simulations;

import java.util.PriorityQueue;
import classes.Customer;
import interfaces.Simulation;
import collections.*;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @class PAC: Pac's approach, Shortest-Job-First
 */
public class PAC implements Simulation<Customer> {

	private static double profit;
	private static int unhappyC;
	private static PriorityQueue<Customer> cQ;
	private static SLLQueue<Customer> cAQ;
	
	/**
	 * Constructor for PAC
	 */
	public PAC() {
		cQ = new PriorityQueue<Customer>();
		cAQ = new SLLQueue<Customer>();;
		unhappyC = 0;
		profit = 0;
	}
	
	/**
	 * Run simulation for Pac's approach
	 */
	public void simulate() {
		int t=0;
		while(!(cAQ.isEmpty()) || !cQ.isEmpty()) {
			while((!cAQ.isEmpty()) && (cAQ.first().arrival() <= t)) {
				cQ.add(cAQ.dequeue());
			}
			if(!cQ.isEmpty()) {
				if(cQ.peek().arrival()<=t) {
					if((cQ.peek().patience()+cQ.peek().arrival())<t) {
						unhappyC++;
						cQ.poll();
					} else if((!cQ.isEmpty())&&(cQ.peek().arrival()<=t) 
							&& !((cQ.peek().patience()+cQ.peek().arrival())<t))  {
						t+=cQ.peek().prepTime();
						profit+=cQ.peek().cost();
						cQ.poll();
					} else
						t++;
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
		return unhappyC++;
	}
	
	/**
	 * @param c Customer to be added in the simulation
	 */
	public void addCustomers(Customer c) {
		cAQ.enqueue(c);
	}
	
	/*
	 * Clear data structures used in the simulation to help Garbage Collector
	 */
	public void clear() {
		cQ.clear();
		cAQ.clear();
	}

}
