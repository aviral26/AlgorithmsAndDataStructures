package HelperDataStructures;


public class Queue<T> {
	
	public int number;
	Node<T> head;
	Node<T> tail;
	
	public Queue(){
		number = 0;
		head = tail = null;
	}
	
	public void add(T s) {
		if(head == null){
			head = new Node<T>(s);
			tail = head;
			number++;
			return;
		}
		
		Node<T> temp = new Node<T>(s);
		tail.next = temp;
		tail = temp;
		number++;
	}

	public T remove() {
		if(this.isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		
		Node<T> temp = head;
		if(number == 1){
			tail = null;
			head = null;
			number--;
			return (T)temp.value;
		}
		head = head.next;
		number--;
		return (T)temp.value;
	}

	public boolean isEmpty() {
		return number == 0;
	}

}
