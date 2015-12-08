import java.io.*;
import java.util.*;

public class Trie{
	
	Vertex root;
	final int RADIX = 26;
	class Vertex{
		int words;
		int prefixes;
		Vertex[] edges;

		Vertex(){
			words = 0;
			prefixes = 0;
			edges = new Vertex[RADIX];
		}
	}

	Trie(){
		root = new Vertex();
	}

	int getPrefixCount(String word){
		Vertex temp = root;

		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(temp.edges[c - 97] != null)
				temp = temp.edges[c - 97];
			else
				break;
		}
		return temp.prefixes;
	}
	int getWords(){
		return root.words;
	}
	int getWordCount(String word){
		Vertex temp = root;
		int i = 0;
		for(i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(temp.edges[c - 97] != null)
				temp = temp.edges[c - 97];
			else
				break;
		}
		if(i == word.length())
			return temp.words;
		return 0;
	}

	void addWord(String word){
		root.words++;
		StringBuilder w = new StringBuilder(word);
		Vertex temp = root;
		//System.out.println("adding word " + word);
		while(w.length() > 1){
			char nextChar = w.charAt(0);
			//System.out.println("next char is " + nextChar);
			if(temp.edges[nextChar - 97] == null)
				temp.edges[nextChar - 97] = new Vertex();
			temp.edges[nextChar - 97].prefixes++;
			temp = temp.edges[nextChar - 97];
			w.deleteCharAt(0);
		}
		if(temp.edges[w.charAt(0) - 97] == null)
			temp.edges[w.charAt(0) - 97] = new Vertex();
		temp.edges[w.charAt(0) - 97].prefixes++;
		temp.edges[w.charAt(0) - 97].words++;
	}
}