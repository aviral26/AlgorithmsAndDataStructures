package HelperDataStructures;

public class Node<T> {
	T value;
	Node next;
	
	Node(T item){
		this.value = item;
		next = null;
	}
}
