package com.prashant.datastrutures.array;

import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

public class ArrayRotationReversalAlgo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfElements = sc.nextInt();
		int arr[] = new int[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			arr[i] = sc.nextInt();
		}
		int r = sc.nextInt();

		ArrayRotationReversalAlgo rotate = new ArrayRotationReversalAlgo();
		rotate.printArray(arr, numberOfElements);
		rotate.leftRotate(arr, r, numberOfElements);
		rotate.printArray(arr, numberOfElements);
	}

	void leftRotate(int arr[], int d, int n) {
		rotateArray(arr, 0, d-1);
		rotateArray(arr, d, n-1);
		rotateArray(arr, 0, n-1);
	}

	void rotateArray(int arr[], int start, int end) {
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	void printArray(int arr[], int size) {
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

	int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}
