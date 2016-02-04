import java.io.*;
import java.util.*;

public class Spiral{
	public static void main(String args[]) throws Exception{
		Scanner in = new Scanner(new FileReader("tree.txt"));
		Tree t = new Tree(in);
		boolean toggle = false;
		LinkedList<Node> slr = new LinkedList<Node>();
		LinkedList<Node> srl = new LinkedList<Node>();

		System.out.println(t.head.value);
		slr.push(t.head.left);
		slr.push(t.head.right);

		while(slr.size() > 0 || srl.size() > 0){
			while(slr.size() > 0){
				Node temp = slr.pop();
				if(temp == null) continue;
				srl.push(temp.right);
				srl.push(temp.left);
				System.out.print(temp.value + " ");
			}
			System.out.println();
			while(srl.size() > 0){
				Node temp = srl.pop();
				if(temp == null) continue;
				slr.push(temp.left);
				slr.push(temp.right);
				System.out.print(temp.value + " ");
			}
			System.out.println();
		}

	}
}

class Node{
	int value;
	Node left;
	Node right;
	Node(int x){
		value = x;
		left = null;
		right = null;
	}
}

class Tree{
	Node head;
	int number_nodes;
	
	Tree(Scanner in){
		number_nodes = in.nextInt();
		if(number_nodes >= 1)
			head = new Node(in.nextInt());
		else throw new IllegalArgumentException();
		
		Node temp, currParent;
		currParent = head;
		LinkedList<Node> q = new LinkedList<Node>();
		
		for(int i = 1; i < number_nodes; i++){
			System.out.println("CHECK: currParent = " + currParent.value);
			int v = in.nextInt();
			if(v != -1){
				temp = new Node(v);
				q.add(temp);
			}
			else
				temp = null;
		
			//System.out.println("CHECK: enqueued value temp = " + temp.value);
			//System.out.println("CHECK: Queue length = " + q.number);
			if(currParent.left == null) {
				if(temp != null) System.out.println("CHECK: adding curr parents left child: " + temp.value);
				else System.out.println("CHECK: adding curr parents left child: null");
				currParent.left = temp;
			}
			else{
				if(temp != null) System.out.println("CHECK: adding curr parents right child: " + temp.value);
				else System.out.println("CHECK: adding curr parents right child: null");
				currParent.right = temp;
				currParent = (Node)q.remove();
			}
		}
	}

}