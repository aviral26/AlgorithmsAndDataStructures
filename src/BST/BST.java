package BST;

import java.util.Scanner;

public class BST {
	
	public class Node{
		public int value;
		Node left;
		Node right;
		Node(int value){
			this.value = value;
			left = null;
			right = null;
		}
	}
	public Node head;
	int size;
	
	public BST(){
		head = null;
		size = 0;
	}
	
	public BST(Scanner in){
		size = in.nextInt();
		System.out.println("Size: " + size);
		head = null;
		for(int i = 0; i < size; i++){
			head = add(head,in.nextInt());
			System.out.println("Head after insert: " + head.value);
		}
	}
	
	public Node add(Node h, int value){
		if(h == null){
			h = new Node(value);
			return h;
		}
			
		if(value < h.value) h.left = add(h.left, value);
		else h.right = add(h.right, value);
		
		return h;
	}
	
	private Node findInOrderSuc(Node h){
		if(h == null) return null;
		Node temp = h.right;
		while(temp.left != null) temp = temp.left;
		return temp;
	}
	
	public Node remove(Node h, int value){
		if(h == null) {
			//System.out.println("Case 1");
			return h;
		}
		
		if(h.value == value){
			//System.out.println("Case 2");
			if(h.left == null && h.right == null) h = null;
			else if(h.left == null && h.right != null){
				int temp = h.value;
				h.value = h.right.value;
				h.right.value = temp;
				h.right = remove(h.right,h.right.value);
			}
			else if(h.left != null && h.right == null){
				int temp = h.value;
				h.value = h.left.value;
				h.left.value = temp;
				h.left = remove(h.left, h.left.value);
			}
			else{
				Node suc = findInOrderSuc(h);
				if(suc == null){
					System.out.println("Oops something went wrong");
					return null;
				}
				int temp = h.value;
				h.value = suc.value;
				suc.value = temp;
				//System.out.println("reached here. suc.value: " + suc.value);
				h.right = remove(h.right, suc.value);
			}
			return h;
		}
		
		if(value < h.value){
			//System.out.println("Case 3");
			h.left = remove(h.left, value);
		}
		else{
			//System.out.println("Case 4");
			h.right = remove(h.right, value);
		}
		
		return h;
	}
	
	public void printInOrder(Node h){
		if(h == null) return;
		
		printInOrder(h.left);
		System.out.print(" " + h.value + " ");
		printInOrder(h.right);
	}
	
	public Node getHead(){
		return this.head;
	}
	
}
