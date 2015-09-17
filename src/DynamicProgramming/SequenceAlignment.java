package DynamicProgramming;

import HelperDataStructures.Bag;

public class SequenceAlignment {
	
	private static final int P_GAP = 2;
	private static final int P_MIS = 1;
	private static final int P_MAT = 0;
	private static final int DIAG = 3;
	private static final int UP = 4;
	private static final int LEFT = 5;
	private static final String GAP = "__";
	
	String X, Y;
	int m, n;
	int[][] memo;
	int[][] route;

	
	public SequenceAlignment(String a, String b, int al, int bl){
		X = a;
		Y = b;
		m = al;
		n = bl;
		memo = new int[m+1][n+1];
		route = new int[m+1][n+1];
		findSA();
	}
	
	private void findSA(){
		
		for(int i = 0; i <= m; i++)
			memo[i][0] = i * P_GAP;
		
		for(int i = 1; i <= n; i++)
			memo[0][i] = i * P_GAP;
		
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				memo[i][j] = minimum((memo[i-1][j-1] + penalty(i,j)), (memo[i-1][j] + P_GAP), (memo[i][j-1] + P_GAP), i, j);
			}
		}
		
		System.out.println("Total penalty: " + memo[m][n]);
		
		int x = m;
		int y = n; 
		System.out.println("The aligned sequences are as follows..");
		while(x > 0 && y > 0){
			if(route[x][y] == DIAG)
				System.out.println(X.charAt(--x) + " " + Y.charAt(--y));
			else if(route[x][y] == UP)
				System.out.println(X.charAt(--x) + " " + GAP);
			else if(route[x][y] == LEFT)
				System.out.println(GAP + " " + Y.charAt(--y));
		}
		
		while(x > 0)
			System.out.println(X.charAt(--x) + " " + GAP);
		 
		while(y > 0)
			System.out.println(GAP + " " + Y.charAt(--y));
		
	}
	
	private int minimum(int a, int b, int c, int i, int j){
		if(a <= b && a <= c){
			route[i][j] = DIAG;
			return a;
		}
	
		if(b <= a && b <= c){
			route[i][j] = UP;
			return b;
		}
		if(c <= a && c <= b){
			route[i][j] = LEFT;
			return c;
		}
		return -1;
	}
	
	private int penalty(int a, int b){
		if(X.charAt(a-1) == Y.charAt(b-1)) return P_MAT;
		return P_MIS;
	}
	
}
