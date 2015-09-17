package StringProcessing;

import java.util.Scanner;

public class KMP {
	
	private int[][] dfa;
	private int R = 256;
	private int M;
	private static final int NOT_FOUND = -1;
	private int X;
	
	public KMP(String pattern){
		M = pattern.length();
		dfa = new int[R][M];
		X = 0;
		dfa[pattern.charAt(0)][0] = 1;
		
		for(int j = 1; j < M ; j++){
			for(int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X];
			dfa[pattern.charAt(j)][j] = j + 1;
			X = dfa[pattern.charAt(j)][X];
		}
	}
	
	public int search(Scanner in){
		in.useDelimiter("");
		for(int i = 0, j = 0; in.hasNext(); i++){
			char c = in.next().charAt(0);
			j = dfa[c][j];
			if(j == M) return i-M+1;
		}
		return NOT_FOUND;
	}
	
}
