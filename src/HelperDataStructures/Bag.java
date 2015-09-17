package HelperDataStructures;
import java.util.Iterator;


public class Bag<T> implements Iterable<T> {
	private int num;
	Node first;
	

	public Bag(){
		first = null;
		num = 0;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return num;
	}
	
	public void add(T item){
		if(first == null){
			first = new Node<T>(item);
			first.next = null;
			num++;
			return;
		}
		
		Node temp = new Node<T>(item);
		temp.next = first;
		first = temp;
		num++;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(first);
	}

}
