package classes;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @class Customer: defines the Customer object
 */
public class Customer implements Comparable<Customer>{
	
	private int momentOfArrival;
	private String customerID;
	private int timeToPrepare;
	private double cost;
	private int levelOfPatience;
	
	/**
	 * Customer constructor
	 * @param arrivalTime	Customer's time of arrival
	 * @param id 			Customer's ID
	 * @param prepareTime 	Customer's order's preparation time
	 * @param cost			Customer's bill
	 * @param patience 		Customer's level of patience
	 */
	public Customer(int arrivalTime, String id, int prepareTime, double cost, int patience){
		customerID = id;
		this.levelOfPatience = patience;
		this.momentOfArrival = arrivalTime;
		this.cost = cost;
		this.timeToPrepare = prepareTime;
	}
	/**
	 * @return Customer ID
	 */
	public String getID() {
		return customerID;
	}
	/**
	 * @return Customer's level of patience
	 */
	public int patience() {
		return levelOfPatience;
	}
	/**
	 * @return Customer's moment of arrival
	 */
	public int arrival() {
		return momentOfArrival;
	}
	/**
	 * @return Customer's bill
	 */
	public double cost() {
		return cost;
	}
	/**
	 * @return Customer's order's preparation time
	 */
	public int prepTime() {
		return timeToPrepare;
	}
	/** (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * @param c Customer
	 * Comparator used for PriorityQueue
	 */
	@Override
	public int compareTo(Customer c) {
		return timeToPrepare - c.prepTime();
	}
}
