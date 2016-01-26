import java.io.IOException;

public class MainClass {
	//static StringBuilder str = new StringBuilder();
	public static void main(String args[]) throws IOException{
		
		palindromeSubstring p = new palindromeSubstring("hidefedihay");
		//generateParens(4);

		// Node head = new Node(1);
		// head.next = new Node(2);
		// head.next.next = new Node(3);
		// head.next.next.next = new Node(4);
		// head.next.next.next.next = new Node(5);
		// head.next.next.next.next.next = new Node(6);
		// head.next.next.next.next.next.next = new Node(7);

		// ReverseQKAtATime r = new ReverseQKAtATime(head, 2);

		// int[][] A = {{1,1,1,0,0,1},{1,1,0,0,1,0},{0,0,0,0,1,1}};
		// NumberOfIslands n = new NumberOfIslands(A);

		// Trie t = new Trie();
		// t.addWord("aviral");
		// t.addWord("aviral");
		// t.addWord("aviral");
		// t.addWord("aviral");
		// t.addWord("aviral");
		// t.addWord("aviral");
		// t.addWord("studies");
		// t.addWord("studies");
		// t.addWord("studies");
		// t.addWord("studies");
		// t.addWord("avi");
		// t.addWord("avira");
		// t.addWord("study");
		// t.addWord("study");
		// t.addWord("study");
		// t.addWord("avi");
		// System.out.println("Total number of words in dictionary are " + t.getWords());
		// System.out.println("prefix count of \"avi\" is " + t.getPrefixCount("avi"));
		// System.out.println("prefix count of \"study\" is " + t.getPrefixCount("study"));
		// System.out.println("prefix count of \"stud\" is " + t.getPrefixCount("stud"));
		// System.out.println("word count of \"aviral\" is " + t.getWordCount("aviral"));
		// System.out.println("word count of \"avira\" is " + t.getWordCount("avira"));
		// System.out.println("word count of \"avi\" is " + t.getWordCount("avi"));
		// System.out.println("word count of \"studies\" is " + t.getWordCount("studies"));
		// System.out.println("word count of \"study\" is " + t.getWordCount("study"));


		// Node root = new Node(20);
		// root.setLeft(new Node(8));
		// root.setRight(new Node(22));
		// root.left.setLeft(new Node(4));
		// root.left.setRight(new Node(12));
		// root.left.right.setLeft(new Node(10));
		// root.left.right.setRight(new Node(14));
	
		// PrintNodeAtDistanceK p = new PrintNodeAtDistanceK(root, 2, 12);
		
		
		
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

	// static void generateParens(int k){
	// 	String s = "";
	// 	generateParensOf(s, k, 0, 0);
	// }
	// static void generateParensOf(String s, int k, int open, int close){
	// 	if(close == k){
	// 		System.out.println(s);
	// 	}
	// 	else{
	// 		if(open > close){
	// 			generateParensOf(s + " } ", k , open, close + 1);
	// 		}
	// 		if(open < k){
	// 			generateParensOf(s + " { ", k , open + 1, close);	
	// 		}
	// 	}
	// }
}
