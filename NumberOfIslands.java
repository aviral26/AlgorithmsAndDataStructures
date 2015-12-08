import java.io.*;
import java.util.*;

class NumberOfIslands{
	int count;
	NumberOfIslands(int[][] A){
		count = 2;
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[0].length; j++){
				if(A[i][j] == 1){
					countIslands(A, i, j);
					count++;
				}
			}
		}
		System.out.println("Number of islands are " + (count - 2));
		for(int i = 0; i < A.length; i++){
			System.out.println();
			for(int j = 0; j < A[0].length; j++)
				System.out.print(A[i][j] + " ");
		}

	}

	void countIslands(int[][] A, int x, int y){
		A[x][y] = count;
		if(x - 1 > 0 && A[x - 1][y] == 1) countIslands(A, x - 1, y);
		if(y - 1 > 0 && A[x][y - 1] == 1) countIslands(A, x, y - 1);
		if(x + 1 < A.length && A[x + 1][y] == 1) countIslands(A, x + 1, y);
		if(y + 1 < A[0].length && A[x][y + 1] == 1) countIslands(A, x, y + 1);
	}
		
}