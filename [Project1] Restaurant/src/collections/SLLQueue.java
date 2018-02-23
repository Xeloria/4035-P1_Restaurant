package collections;

import interfaces.Queue;

public class SLLQueue<E> implements Queue<E> {

	private Node<E> first, last;
	private int size;
	
	public SLLQueue(){
		first = null;
		last = first;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E first() {
		if(isEmpty()) return null;
		return first.getElement();
	}
	
	public void enqueue(E e) {
		if(isEmpty()) {
			first = new Node<E>(e, null);
			last = first;
		} else {
			last.setNext(new Node<E>(e, null));
			last = last.getNext();
		}
		size++;
	}

	public E dequeue() {
		if(isEmpty()) return null;
		Node<E> ntr = first;
		first = first.getNext();
		if(size == 1) last = null;
		E etr = ntr.getElement();
		ntr.clean();
		size--;
		return etr;
	}
	
	public void clear(){
		Node<E> n = first,m;
		while(n!=null){
			m = n;
			n = n.getNext();
			m.clean();
		}
	}
	
	@Override
	public void showReverse() { 
	    if (size == 0)
		   System.out.println("Queue is empty."); 
		else
		   recSR(first);
    } 
    private void recSR(Node<E> f) { 
		if (f != null) { 
		   recSR(f.getNext()); 
		   System.out.println(f.getElement()); 
	     } 
    }
	
	
	/*************
	 * NODE CLASS*
	 *************/
	private static class Node<T>{
		private T element; 
		private Node<T> next; 
		public Node() { 
			element = null; 
			next = null; 
		}
		public Node(T data, Node<T> next) { 
			this.element = data; 
			this.next = next; 
		}
		public Node(T data)  { 
			this.element = data; 
			next = null; 
		}
		public T getElement() {
			return element;
		}
		public void setElement(T data) {
			this.element = data;
		}
		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
		public void clean() {
			this.setElement(null);
			this.setNext(null);
		}
	}
	
}
