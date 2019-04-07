package com.prashant.datastrutures.array;

import java.util.Scanner;

public class RotationCount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numberOfElements = sc.nextInt();
		int arr[] = new int[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			arr[i] = sc.nextInt();
		}
		RotationCount rotate = new RotationCount();
		rotate.printArray(arr, numberOfElements);
		int countOfRotations = rotate.countRotate(arr, 0, numberOfElements-1);
		System.out.println(countOfRotations);
	}
	
	int countRotate(int arr[], int start, int end) {
		if(end < start)
		{
			return 0;
		}
		if(start == end) {
			return start;
		}
		int mid = start+(end-start)/2;
		if(arr[mid] < arr[mid-1])
			return mid;
		if(arr[mid] > arr[mid+1])
			return mid+1;
		if(arr[mid] > arr[end])
			return countRotate(arr, mid+1, end);
		return countRotate(arr, start, mid-1);
	}
	void printArray(int arr[], int size) {
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

}
