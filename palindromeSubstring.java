import java.io.*;
import java.util.*;

public class palindromeSubstring{
	String str;
	int[][] memo;

	public palindromeSubstring(String s){
		str = s;
		memo = new int[str.length() + 1][str.length() + 1];

		for(int i = 0; i <= str.length(); i++)
			memo[i][i] = 1;
		
		for(int l = 1; l <= str.length(); l++){
			for(int i = 1; i <= str.length() - l; i++){
				int j = i + l;
				if(str.charAt(i - 1) == str.charAt(j - 1))
					memo[i][j] = 2 + maximum(i, j);
				else
					memo[i][j] = maximum(i,j);
			}
		}
		System.out.println("Length of longest palindrome substring is " + memo[1][str.length()]);
		printSub();
	}

	private int maximum(int i, int j){
		return memo[i][j - 1] > memo[i + 1][j] ? memo[i][j - 1] : memo[i + 1][j];
	}

	private void printSub(){
		int j = str.length();
		int i = 1;
		while(true){
			if(i > str.length() || j < 1) break;
			if(memo[i][j] == j - i + 1){
				System.out.println(str.substring(i-1, j));
				break;
			}
			if(memo[i][j - 1] > memo[i + 1][j])
				j--;
			else
				i++;
		}
	}
		
}