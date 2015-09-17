package DynamicProgramming;

import HelperDataStructures.Bag;

public class MaxLengthPalindrome {
	
	int[][] memo;
	int length;

	public MaxLengthPalindrome(char[] str){
		length = str.length;
		memo = new int[length][length];
		for(int i = 0; i < length; i++){
			memo[i][i] = 1;
			if(i + 1 < length && str[i] == str[i + 1]) memo[i][i + 1] = 2;
			else if(i + 1 < length && str[i] != str[i + 1]) memo[i][i + 1] = 0;
		}

		for(int l = 3; l <= length; l++)
			for(int i = 0; i <= length - l; i++){
				int j = i + l - 1;
				if(str[i] == str[j]) memo[i][j] = memo[i + 1][j - 1] + 2;
				else memo[i][j] = memo[i + 1][j] < memo[i][j-1] ? memo[i][j - 1] : memo[i + 1][j];
			}
						
		System.out.println("Max length Palindrome --> " + memo[0][length - 1]);
	}
	
}
