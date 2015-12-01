import java.io.*;
import java.util.*;

public class Levenshtein{
	String A, B;
	int n, m;
	int[][] memo;

	Levenshtein(String A, String B){
		this.A = A;
		this.B = B;
		n = A.length();
		m = B.length();
		memo = new int[n + 1][m + 1];
		
		for(int i = 0; i < m + 1; i++)
			memo[0][i] = i;

		for(int i = 0; i < n; i++)
			memo[i][0] = i;

		findMinEdits();
		printMemo();
	}

	private void findMinEdits(){
		for(int i = 1; i <= m; i++)
			for(int j = 1; j <= n; j++){
				if(A.charAt(i) == A.charAt(j)){
					memo[i][j] = memo[i - 1][j - 1];
				}
				else{
					memo[i][j] = 1 + minimum(memo[i - 1][j - 1], memo[i][j - 1], memo[i - 1][j]);
				}
			}
	}

	private void printMemo(){
		for(int i = 0; i <= m; i++){
			System.out.println();
			for(int j = 0; j <= n; j++)
				System.out.print(memo[i][j] + " ");
		}
		System.out.println();
		System.out.println("Minimum number of transformations required are: " + memo[m][n]);
	}

	private int minimum(int x, int y, int z){
		return x > y ? (x > z ? x : (z > y ? z : y)) : (y > z ? y : (x > z ? x : z));
	}
}       