package hackerrank;



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public  class Solution {
	   
	public  static void main(String[] args)
	{
		int arr[] = {12, 3, 5, 7, 19};
		Arrays.sort(arr);
		for (int i=0;i<arr.length;i++){System.out.println(arr[i]);}
		
		int k=3	;
		if(k>arr.length-1){
			
			System.out.println("above the length");
			}
		else
		System.out.println(arr[k-1]  + " is the "+ k+ " smallest element in the array");
	}
}

