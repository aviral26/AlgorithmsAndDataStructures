package DynamicProgramming;

public class LCS {
	private static final int DIAG = 3;
	private static final int UP = 4;
	private static final int LEFT = 5;
	
	String X, Y;
	int m, n;
	int[][] memo;
	int[][] route;
	
	public LCS(String a, String b, int al, int bl){
		X = a;
		Y = b;
		m = al;
		n = bl;
		memo = new int[m+1][n+1];
		route = new int[m+1][n+1];
		findLCS();
	}
	
	private void findLCS(){
		for(int i = 0; i <= m; i++)
			memo[i][0] = 0;
		for(int i = 1; i <= n; i++)
			memo[0][i] = 0;
		
		for(int i = 1; i <= m; i++)
			for(int j = 1; j <= n; j++){
				if(X.charAt(i-1) == Y.charAt(j-1)){
					memo[i][j] = 1 + memo[i-1][j-1];
					route[i][j] = DIAG;
				}
				else{
					if(memo[i-1][j] > memo[i][j-1]){
						memo[i][j] = memo[i-1][j];
						route[i][j] = UP;
					}
					else{
						memo[i][j] = memo[i][j-1];
						route[i][j] = LEFT;
					}
				}
			}
		
		System.out.println("Length of LCS: " + memo[m][n]);
		System.out.println("LCS is: ");
		int x = m;
		int y = n;
		
		while(x > 0 && y > 0){
			if(route[x][y] == DIAG)
				System.out.println(X.charAt(--x) + " " + Y.charAt(--y));
			else if(route[x][y] == UP)
				--x;
			else if(route[x][y] == LEFT)
				--y;
		}
	}
}
