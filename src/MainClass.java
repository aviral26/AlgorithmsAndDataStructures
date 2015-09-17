import java.io.IOException;

import BST.EmptyTreeException;
import StringProcessing.Combinations;


public class MainClass {
	
	public static void main(String args[]) throws IOException, EmptyTreeException{
		
		Combinations p = new Combinations("mal");
		
		
		
		//char[] arr = {'A','G','C','T','C','B','M','A','A','C','T','G','G','A','M'};
		//new MaxLengthPalindrome(arr);
		/*int[] cost = {1, 5, 3, 4};
		int[] val = {15, 10, 9, 5}; 
		new Knapsack(8, cost, val, 4);
		*//*Scanner in;
		
		in = new Scanner(new File("D:\\Algorithms and Data Structures\\AlgorithmsAndDataStructures\\src\\DataFiles\\numbers.txt"));
		//BST myTree = new BST(in);
		String[] num;
		int count;
		count = in.nextInt();
		num = new String[count];
		for(int i = 0; i < count; i++)
			num[i] = in.next();
		System.out.println("The unsorted list is: ");
		for(int i = 0; i < count; i++)
			System.out.println(num[i]);
		
		//Integer[] temp = new Integer[count];
		//new Sorts().mergeSort(num, temp, 0, count-1);
		
		new Sorts().radixSort(num, 256, 3);
		System.out.println("The sorted list is: ");
		for(int i = 0; i < count; i++)
			System.out.println(num[i]);
	*/	
	
	//	AVLTree myHBTree = new AVLTree(in);
		//System.out.println("Hi. Both trees are ready. The BT is: ");
		//myTree.printInOrder(myTree.head);
		//System.out.println();
		//System.out.println("The AVLT is: ");
		//myHBTree.printInOrder(myHBTree.head);
		/*System.out.println("Deleting head " + myTree.head.value + " and printing tree..");
		myTree.head = myTree.remove(myTree.head, myTree.head.value);
		System.out.println();
		myTree.printInOrder(myTree.head);*/
	}
}
