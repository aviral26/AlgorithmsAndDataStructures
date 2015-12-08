public class Node {
	int val;
	Node left;
	Node right;
	
	public Node(int item){
		this.val = item;
		left = null;
		right = null;
	}

	public void setLeft(Node t){
		left = t;
	}
	public void setRight(Node t){
		right = t;
	}
}
