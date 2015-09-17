package StringProcessing;

public class LSDRadixSort {

	String[] aux;
	int[] count;
	
	public LSDRadixSort(String[] s, int R, int W){
		
		int N = s.length;
		aux = new String[N];
		
		
		for(int d = W - 1; d >= 0; d--){
			
			count = new int[R+1];
			
			for(int i = 0; i < N; i++)
				count[s[i].charAt(d) + 1]++;
			
			for(int i = 0; i < R; i++)
				count[i+1] += count[i];
			
			for(int i = 0; i < N; i++){
				aux[count[s[i].charAt(d)]++] = s[i];
			}
			
			for(int i = 0; i < N; i++)
				s[i] = aux[i];
			
		}
		
	}
	
}
