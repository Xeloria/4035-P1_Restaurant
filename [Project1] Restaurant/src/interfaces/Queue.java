package interfaces;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @interface Queue
 * @param <E>
 */
public interface Queue<E> {
	
	/**
	 * @return size
	 */
	int size();
	
	/**
	 * @return size == 0
	 */
	boolean isEmpty();
	
	/**
	 * @return First element in the queue
	 */
	E first();
	
	/**
	 * @param add new element
	 */
	void enqueue(E element);
	
	/**
	 * @return retrieve first element
	 */
	E dequeue();
	
	/**
	 * Show elements reversed
	 */
	void showReverse();
}
