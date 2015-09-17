package DynamicProgramming;

import HelperDataStructures.Bag;

public class Knapsack {
	int[][] memo;
	int[] weight;
	int capacity;
	int[] value;
	int n;
	
	public Knapsack(int c, int[] cost, int[] val, int num){
		capacity = c;
		n = num;
		weight = new int[n+1];
		value = new int[n+1];
		memo = new int[n+1][capacity+1];
		for(int i = 1; i <= n; i++){
			weight[i] = cost[i-1];
			value[i] = val[i-1];
		}
		fillSack();
	}
	
	private void fillSack(){
		for(int i = 0; i <= n; i++)
			memo[i][0] = 0;
		for(int i = 0; i <= capacity; i++)
			memo[0][i] = 0;
		for(int i = 1; i <= n; i++){
			for(int x = 1; x <= capacity; x++){
				if(weight[i] > x) memo[i][x] = memo[i-1][x];
				else memo[i][x] = maximum(memo[i-1][x], memo[i-1][x-weight[i]] + value[i], i);
			}
		}
		System.out.println("Maximum value --> " + memo[n][capacity]);
		System.out.println("Memo..");
		for(int i = 0; i <= n; i++){
			System.out.println();
			for(int j = 0; j <= capacity; j++)
				System.out.print("   " + memo[i][j] + "   ");
	
		}
		System.out.println("");
		System.out.println("Items to be included --> ");
		int i = n;
		int w = capacity;
		while(i > 0 && w > 0){
			if(memo[i][w] != memo[i-1][w]){
				System.out.println(i);
				w -= weight[i];
				i--;
			}
			else i--;
		}
		
	}
	
	private int maximum(int without, int with, int i){
		if(with > without){
			return with;
		}
		return without;
	}
}
