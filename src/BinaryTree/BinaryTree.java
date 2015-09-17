package BinaryTree;

import java.util.Scanner;

import HelperDataStructures.Queue;


public class BinaryTree {
	
	private class Node{
		int value;
		Node left;
		Node right;
		Node(int value){
			this.value = value;
			left = null;
			right = null;
		}
	}
	Node head;
	int number_nodes;
	
	public BinaryTree(Scanner in){
		int number_nodes = in.nextInt();
		if(number_nodes >= 1)
			head = new Node(in.nextInt());
		else throw new IllegalArgumentException();
		
		Node temp, currParent;
		currParent = head;
		Queue<Node> q = new Queue<Node>();
		
		for(int i = 1; i < number_nodes; i++){
			//System.out.println("CHECK: currParent = " + currParent.value);
			temp = new Node(in.nextInt());
			q.add(temp);
			//System.out.println("CHECK: enqueued value temp = " + temp.value);
			//System.out.println("CHECK: Queue length = " + q.number);
			if(currParent.left == null) currParent.left = temp;
			else{
				currParent.right = temp;
				currParent = (Node)q.remove();
			}
		}
		
	}
	
	public Node getHead(){
		return head;
	}
	
	public void printBinaryTreeInOrder(Node h){
		if(h == null)return;
		printBinaryTreeInOrder(h.left);
		System.out.println(h.value);
		printBinaryTreeInOrder(h.right);
	}
	
	public void printBinaryTreeLevelOrder(){
		Node t;
		Queue<Node> q = new Queue<Node>();
		q.add(head);
		while((t = q.remove()) != null){
			
			//System.out.println("length after removing: " + q.number);
			System.out.println(t.value);
			q.add(t.left);
			q.add(t.right);
			//System.out.println("length after adding two: " + q.number);
		}
	}
	
	public int numberOfNodes(){
		System.out.println("Enter number of nodes: ");
		return new Scanner(System.in).nextInt();
	}
}
