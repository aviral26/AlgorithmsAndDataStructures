package StringProcessing;

import java.util.Stack;

import DirectedGraphs.Digraph;
import DirectedGraphs.DirectedDFS;
import HelperDataStructures.Bag;

public class NFA {

	private char[] re;
	private Digraph G;
	private int M;
	
	public NFA(String regex){
		M = regex.length();
		re = regex.toCharArray();
		G = buildEpsilonTransitionDigraph();
	}
	
	public boolean recognizes(String pattern){
		
		Bag<Integer> pc = new Bag<Integer>();
		DirectedDFS dfs = new DirectedDFS(G, 0);
		for(int i = 0; i < G.V(); i++)
			if(dfs.marked[i]) pc.add(i);
		
		for(int i = 0; i < pattern.length(); i++){
			
			Bag<Integer> matches = new Bag<Integer>();
			for(int v : pc){
				if(v == M) continue;
				if(re[v] == pattern.charAt(i) || re[v] == '.')	
					matches.add(v+1);
			}
			dfs = new DirectedDFS(G, matches);
			pc = new Bag<Integer>();
			for(int j = 0; j < dfs.marked.length; j++)
				if(dfs.marked[j]) pc.add(j);
		}
		for(int x : pc)
			if(x == M) return true;
		return false;		
	}
	
	private Digraph buildEpsilonTransitionDigraph(){
		
		Digraph G = new Digraph(M+1);
		Stack<Integer> ops = new Stack<Integer>();
		
		for(int i = 0; i < M; i++){
			int lp = i;
			
			if(re[i] == '(' || re[i] == '|') ops.push(i);
			
			else if(re[i] == ')'){
				int or = ops.pop();
				if(re[or] == '|'){
					lp = ops.pop();
					G.addEdge(lp, or+1);
					G.addEdge(or, i);
				}
				else lp = or;
			}
			
			if((i+1) < M && re[i+1] == '*'){
				G.addEdge(lp, i+1);
				G.addEdge(i+1, lp);
			}
			
			if(re[i] == '(' || re[i] == '*' || re[i] == ')')
				G.addEdge(i, i+1);
		}
		return G;		
	}
	
}
