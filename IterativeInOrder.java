import java.io.*;
import java.util.*;

public class IterativeInOrder{
	public IterativeInOrder(pTree head){
		pTree temp = head;
		pTree prev = null;

		while(temp != null){
			if(prev != null){
				if(temp.left != prev && temp.right != prev){
					if(temp.left != null){
						prev = temp;
						temp = temp.left;
					}
					else{
						System.out.print(" " + temp.value + " ");
						if(temp.right != null){
							prev = temp;
							temp = temp.right;
						}
						else{
							prev = temp;
							temp = temp.parent;
						}
					}
				}
				else if(temp.left == prev){
					System.out.print(" " + temp.value + " ");
					if(temp.right != null){
						prev = temp;
						temp = temp.right;
					}
					else{
						prev = temp;
						temp = temp.parent;
					}
				}
				else{
					prev = temp;
					temp = temp.parent;
				}
			}
			else{
				if(temp.left != null){
					prev = temp;
					temp = temp.left;
				}
				else{
					System.out.print(" " + temp.value + " ");
					if(temp.right != null){
							prev = temp;
							temp = temp.right;
						}
					else{
						prev = temp;
						temp = temp.parent;
					}
				}
			}
		}
	}
}