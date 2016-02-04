import java.io.*;
import java.util.*;

public class ValuePos{

	public ValuePos(int[] A){
		System.out.println(search(0,A.length - 1,A));
	}

	int search(int low, int high, int[] A){
		if(low == high){
			System.out.println("low " + low + " high " + high);
			return A[low] == low ? low : -1;
		}

		if(low < high){
			System.out.println("low " + low + " high " + high);
			int mid = (low + high) / 2;
			if(A[mid] == mid) {
				System.out.println("found mid " + mid);
				return mid;
			}
			if(A[mid] > mid) return search(low, mid - 1, A);
			if(A[mid] < mid) return search(mid + 1, high, A);
		}
		return -1;
	}
}



// {0,2,2,4,5,7,9};
//	0 1 2 3 4 5 6