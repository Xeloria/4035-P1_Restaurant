package interfaces;

/**
* @author Alexander J. Cintron Baez
* @email alexander.cintron1@upr.edu
* @studentID 802-15-1388 | UPRM
* @interface Simulation
* @param <E>
*/
public interface Simulation<E> {
	
	/**
	 * Run simulation
	 */
	void simulate();
	
	/**
	 * @param e Element to be added 
	 */
	void addCustomers(E e);
	
	/**
	 * @return Profit generated
	 */
	double getProfit();
	
	/**
	 * @return Number of disappointed Customers
	 */
	int getMadCust();
	
	/**
	 * Help Garbage Collector
	 */
	void clear();
}
