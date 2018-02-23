package collections;

import interfaces.Stack;

public class LLStack<E> implements Stack<E> {
	private SNode<E> top; 
	private int size; 
	
	public LLStack() {
		top = null; 
		size = 0; 
	}
	
	public E pop() {
		if (isEmpty()) return null; 
		E etr = top.getElement(); 
		top = top.getNext();
		size--;
		return etr;
	}

	public void push(E e) {
		top = new SNode<E>(e,top);
		size++; 
	}

	public E top() {
		if (isEmpty()) return null; 
		return top.getElement();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

    public void showReverse() { 
	    if (size == 0)
		   System.out.println("Stack is empty."); 
		else
		   recSR(top);
    } 
    private void recSR(SNode<E> f) { 
		if (f != null) { 
		   recSR(f.getNext()); 
		   System.out.println(f.getElement()); 
	     } 
    } 
    
    public void clear() {
    	SNode<E> n = top, m;
    	while(n!=null){
			m = n;
			n = n.getNext();
			m.clean();
    	}
    }
    
    private class SNode<E>  {
    	private E element; 
    	private SNode<E> next; 
    	public SNode() { 
    		element = null; 
    		next = null; 
    	}
    	public SNode(E data, SNode<E> next) { 
    		this.element = data; 
    		this.next = next; 
    	}
    	public SNode(E data)  { 
    		this.element = data; 
    		next = null; 
    	}
    	public E getElement() {
    		return element;
    	}
    	public void setElement(E data) {
    		this.element = data;
    	}
    	public SNode<E> getNext() {
    		return next;
    	}
    	public void setNext(SNode<E> next) {
    		this.next = next;
    	}
    	public void clean() { 
    		element = null; 
    		next = null; 
    	}
    }
}
