import java.io.*;
import java.util.*;

public class PrintNodeAtDistanceK{
	int distance = 0;
	final int MAX = 100;
	Node value; 
	int count = 0;

	PrintNodeAtDistanceK(Node root, int k, int v){
		System.out.println("Return value: " + NodeAtDistanceK(root, k, v));
	}

	int NodeAtDistanceK(Node root, int k, int v){
		
		if(root == null) return -1;
		if(root.val == v){
			printSubTreeNodesAtDistanceK(root, k);
			return 1;
		}
		int ret_val = NodeAtDistanceK(root.left, k , v);
		if(ret_val > 0){
			if(ret_val == k){
				System.out.println(root.val);
				return ret_val + 1;
			}
			if(ret_val < k){
				printSubTreeNodesAtDistanceK(root.right, k - (ret_val + 1));
				return ret_val + 1;
			}
			return ret_val + 1;
		}
		
		ret_val = NodeAtDistanceK(root.right, k , v);
		if(ret_val > 0){
			if(ret_val == k){
				System.out.println(root.val);
				return ret_val + 1;
			}
			if(ret_val < k){
				printSubTreeNodesAtDistanceK(root.left, k - (ret_val + 1));
				return ret_val + 1;
			}
			return ret_val + 1;
		}
		return -1;
	}

	void printSubTreeNodesAtDistanceK(Node root, int k){
		if(root == null) return;
		if(k == 0){
			System.out.println(root.val);
			return;
		}
		printSubTreeNodesAtDistanceK(root.left, k - 1);
		printSubTreeNodesAtDistanceK(root.right, k - 1);
	}
}
