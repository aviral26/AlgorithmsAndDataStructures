package DynamicProgramming;

public class SubsetSum {
	
	int sum;
	int[] A;
	int length;
	int[][] memo;
	public SubsetSum(int s, int[] A, int l){
		sum = s;
		length = l;
		this.A = new int[length];
		for(int i =0; i < length; i++)
			this.A[i] = A[i];
		
		memo = new int[length + 1][sum + 1];
		findSubset();
	}
	
	private void findSubset(){
		for(int i = 0; i <= sum; i++)
			memo[0][i] = 0;
		
		for(int i = 1; i <= length; i++)
			for(int j = 0; j <= sum; j++){
				if(j - A[i-1] >= 0){
					memo[i][j] = maximum(memo[i-1][j], memo[i-1][j - A[i-1]] + A[i-1]);
				}
				else memo[i][j] = memo[i-1][j];
			}
		System.out.println("Sum --> " + memo[length][sum]);
		System.out.println("The elements are..");
		int x = length;
		int y = sum;
		while(x > 0 && y > -1){
			if(memo[x][y] != memo[x-1][y]){
				System.out.println(A[x - 1]);
				y = y - A[x - 1];
				x--;
			}
			else x--;
		}
	}
	
	private int maximum(int a, int b){
		return a <= b ? b : a;
	}
}
