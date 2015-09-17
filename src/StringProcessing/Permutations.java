package StringProcessing;

public class Permutations {
	String s;
	StringBuilder aux;
	boolean[] used;
	int length;
	int count;
	public Permutations(String string){
		s = string;
		count = 1;
		aux = new StringBuilder(s);
		used = new boolean[s.length()];
		length = s.length();
		permutations(s,aux, 0, used);
	}
	
	private void permutations(String original, StringBuilder auxilary, int depth, boolean[] used){
		if(depth == length) {
			System.out.println(count++ + ". " + auxilary);
			return;
		}
		for(int i = 0; i < length; i++){
			if(!used[i]){
				auxilary.setCharAt(depth, original.charAt(i));
				used[i] = true;
				permutations(original, auxilary, depth + 1, used);
				used[i] = false;
			}
		}
	}
}
