package StringProcessing;

public class Combinations {
	String s;
	int length;
	int count;
	
	public Combinations(String string){
		s = string;
		length = string.length();
		count = 1;
		combinations("", s);
	}
	
	private void combinations(String prefix, String s){
		System.out.println(prefix);
        for (int i = 0; i < s.length(); i++)
            combinations(prefix + s.charAt(i), s.substring(i + 1));
	}
	
	
}
