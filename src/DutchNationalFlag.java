import java.io.*;
import java.util.*;

public class DutchNationalFlag{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter array length: ");
		int length = in.nextInt();
		int[] array = new int[length];
		System.out.println("Enter array: ");
		for(int i = 0; i < length; i++){
			array[i] = in.nextInt();
		}

		System.out.print("You entered: ");
		for(int i = 0; i < length; i++)
			System.out.print(array[i] + " ");

		int smaller = 0;
		int equal = 0;
		int larger = length - 1;
		System.out.println("Enter pivot: ");
		int pivot = in.nextInt();

		while(equal <= larger){
			
			if(array[equal] < array[pivot]){
				int temp = array[equal];
				array[equal] = array[smaller];
				array[smaller] = temp;
				equal++;
				smaller++;
			}
			else if(array[equal] == array[pivot])
				equal++;
			else{
				int temp = array[equal];
				array[equal] = array[larger];
				array[larger] = temp;
				larger--;
			}

			
		}

		System.out.print("After processing: ");
		for(int i = 0; i < length; i++)
			System.out.print(array[i] + " ");

		System.out.println();
	}

}