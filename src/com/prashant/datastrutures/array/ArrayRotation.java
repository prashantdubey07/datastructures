package com.prashant.datastrutures.array;

import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

public class ArrayRotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfElements =sc.nextInt();
		int arr[] = new int[numberOfElements];
		for(int i=0; i<numberOfElements;i++) {
			arr[i] = sc.nextInt();
		}
		int r = sc.nextInt();
		
		ArrayRotation rotate = new ArrayRotation();
		rotate.printArray(arr,numberOfElements);
		rotate.leftRotate(arr,r, numberOfElements);
		rotate.printArray(arr,numberOfElements);
	}
	
	
	 void leftRotate(int arr[], int d, int n) 
	    { 
	        int i, j, k, temp; 
	        for (i = 0; i < gcd(d, n); i++) { 
	            temp = arr[i]; 
	            j = i; 
	            while (true) { 
	                k = j + d; 
	                if (k >= n) 
	                    k = k - n; 
	                if (k == i) 
	                    break; 
	                arr[j] = arr[k]; 
	                j = k; 
	            } 
	            arr[j] = temp; 
	        } 
	    } 
	  
	    void printArray(int arr[], int size) 
	    { 
	        int i; 
	        for (i = 0; i < size; i++) 
	            System.out.print(arr[i] + " "); 
	    } 
	  
	    int gcd(int a, int b) 
	    { 
	        if (b == 0) 
	            return a; 
	        else
	            return gcd(b, a % b); 
	    } 

}
