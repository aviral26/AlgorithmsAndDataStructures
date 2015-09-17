package HelperDataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;



public class HT {
	private static int MAX = 10;
	Node[] table;
	
	protected class Node{
		String key;
		String value;
		Node next;
		Node(String k, String v){
			key = k;
			value = v;
			next = null;
		}
	}
	
	public HT(){
		table = new Node[MAX];
		for(int i = 0; i < MAX; i++)
			table[i] = null;
	}
	
	public void insert(String k, String v){
		int index = hashCode(k);
		if(table[index] == null) table[index] = new Node(k, v);
		else{
			Node temp = table[index];
			while(temp.next != null) temp = temp.next;
			temp.next = new Node(k, v);
		}
	}
	
	public boolean contains(String k){
		int index = hashCode(k);
		if(table[index] == null) return false;
		return true;
	}
	
	public Iterator getValues(String k){
		if(!contains(k)) throw new NoSuchElementException();
		return new HTIterator(table[hashCode(k)]);
	}
	
	private int hashCode(String k){
		return 0;
	}
	
}
