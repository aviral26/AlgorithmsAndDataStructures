import java.io.*;
import java.util.*;

public class ReverseQKAtATime{
	Node reversed_q;
	public ReverseQKAtATime(Node head, int k){
		System.out.println("Original queue");
		printQ(head);
		reversed_q = reverseQ(head, k);
		System.out.println("Queue which is reversed " + k + " nodes at a time");
		printQ(reversed_q);
	}

	private Node reverseQ(Node head, int k){
		if(head == null || head.next == null) return head;
		Node r = null;
		Node p = head;
		Node q = head.next;
		int counter = k - 1;
		Node nxt = p;
		
		while(p != null && counter > 0){
			counter--;
			p.next = r;
			if(q != null) r = q.next;
			else r = null;
			if(q != null) q.next = p;
			p = r;
			r = q;
			if(p != null) q = p.next;
		}
		head = r;
		//System.out.println("p: " + p.value + " q: " + q.value + " r: " + r.value);
		nxt.next = reverseQ(p, k);
		return head;
	}

	private void printQ(Node head){
		Node p = head;
		while(p != null){
			System.out.print(p.value + " --> ");
			p = p.next;
		}
		System.out.print(" null");
		System.out.println();
	}

}