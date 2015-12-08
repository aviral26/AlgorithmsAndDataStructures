import java.io.*;
import java.util.*;

public class SmallestMissingInteger{
	int[] A;
	
	SmallestMissingInteger(int[] A){
		this.A = A;
		System.out.println("running..");
		for(int i = 0; i < A.length; i++){
			if(A[i] > 0 && A[i] < A.length && A[A[i] - 1] != A[i]){
				swap(A[i] - 1, i);
				i--;
			}
		}
		System.out.println("computed..");
		for(int i = 0; i < A.length; i++){
			System.out.println("second pass..");
			if(A[i] != i + 1) {
				System.out.println(i + 1);
				break;
			}
		}
		System.out.println("hmm?");
	}

	private void swap(int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}