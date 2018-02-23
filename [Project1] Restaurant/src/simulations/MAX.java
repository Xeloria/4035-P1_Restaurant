package simulations;

import java.util.Comparator;
import java.util.PriorityQueue;
import classes.Customer;
import interfaces.Simulation;
import collections.*;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @class MAX: Max's approach, Max-Profit-First
 */
public class MAX implements Simulation<Customer> {

	private static double profit;
	private static int unhappyC;
	private static PriorityQueue<Customer> cQ;
	private static SLLQueue<Customer> cAQ;
	private static Compare comparator;
	
	/**
	 * Constructor for MAX
	 */
	public MAX() {
		comparator = new Compare();
		cQ = new PriorityQueue<Customer>(2, comparator);
		cAQ = new SLLQueue<Customer>();
		unhappyC = 0;
		profit = 0;
	}
	
	/**
	 * Run simulation for Max's approach
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
	 * @return Profit generate by Max's approach
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
		cAQ.enqueue(c);
	}
	
	/*
	 * Clear data structures used in the simulation to help Garbage Collector
	 */
	public void clear() {
		cQ.clear();
		cAQ.clear();
	}
	
	
	/**
	 * @class Compare
	 */
	class Compare implements Comparator<Customer>{
		/** (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 * @param c Customer
		 * Comparator used for PriorityQueue
		 */
		@Override
		public int compare(Customer c1, Customer c2) {
			return (c1.cost()<=c2.cost())? 1: -1;
		}	
	}
}
