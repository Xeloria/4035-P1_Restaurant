package interfaces;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @interface Stack
 * @param <E>
 */
public interface Stack<E> {
	
	/**
	 * @return size
	 */
	int size(); 
	
	/**
	 * @return size == 0
	 */
	boolean isEmpty();
	
	/**
	 * @return Element on top; last element added in the Stack
	 */
	E top();
	
	/**
	 * @return retrieve element on top
	 */
	E pop();
	
	/**
	 * @param e add new element
	 */
	void push(E e); 
}
