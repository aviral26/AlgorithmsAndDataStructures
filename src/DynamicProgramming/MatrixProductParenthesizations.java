package DynamicProgramming;

public class MatrixProductParenthesizations {
	
	private static final int INF = 999999;
	int[] p;
	int n;
	int[][] memo;
	int[][] pos;
	
	public MatrixProductParenthesizations(int[] p, int num){
		this.p = new int[num+1];
		for(int i = 0; i < this.p.length; i++)
			this.p[i] = p[i];
		n = num;
		memo = new int[num + 1][num + 1];
		pos = new int[num + 1][num + 1];
		findP();
	}
	
	private void findP(){
		
		for(int i = 0; i <= n; i++)
			memo[i][i] = 0;
		
		for(int l = 1; l <= n; l++)
			for(int i = 1; i <= n - l; i++){
				int j = i + l;
				memo[i][j] = minimum(i, j);
			}
		System.out.println("The minimum cost of multiplication is: " + memo[1][n]);
		System.out.println("The matrix chain multiplication order is: ");
		printChain(1, pos[1][n], n);
	}
	
	private int minimum(int i, int j){
		int min = INF;;
		for(int k = i; k < j; k++){
			int temp = memo[i][k] + memo[k + 1][j] + (p[i-1] * p[k] * p[j]);
			if(temp < min){
				min = temp;
				pos[i][j] = k;
			}
		}
		return min;
	}
	
	private void printChain(int start, int paran, int last){
		if(start == last){
			System.out.print("A" + start);
			return;
		}
		if(start == last - 1){
			System.out.print("A" + start + ".A" + last);
			return;
		}
		System.out.print("(");
		printChain(start, pos[start][paran], paran);
		System.out.print(").(");
		printChain(paran + 1, pos[paran + 1][last], last);
		System.out.print(")");
	}
	
}
