package DynamicProgramming;


public class LongestIncreasingSubsequence {
	int[] memo;
	
	public LongestIncreasingSubsequence(int[] arr){
		memo = new int[arr.length];
		findLIS(arr);
	}
	
	private void findLIS(int[] arr){
		for(int i = 0; i < arr.length; i++)
			memo[i] = 1;
		
		for(int l = 0; l < arr.length; l++)
			for(int i = 0; i < l; i++)
				if(arr[l] > arr[i] && memo[l] < memo[i] + 1)
					memo[l] = memo[i] + 1;
			
		
		int max = 0;
		for(int i = 0; i < memo.length; i++)
			max = memo[i] > max ? memo[i] : max;
		System.out.println("Maximum length increasing subsequence --> " + max);	
		
		for(int i = 0; i < memo.length; i++)
			System.out.println(memo[i]);
		
	}
}
