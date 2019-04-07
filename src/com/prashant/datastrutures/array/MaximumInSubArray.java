package com.prashant.datastrutures.array;

import java.util.Scanner;

public class MaximumInSubArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfElements =sc.nextInt();
		int k= sc.nextInt();
		long arr[] = new long[numberOfElements];
		for(int i=0; i<numberOfElements;i++) {
			arr[i] = sc.nextLong();
		}
		findMaximumInSubArray(arr,k);
		
	}
	public static void findMaximumInSubArray(long arr[],int k)
	{
		if(arr.length ==0 )
			return;
		long maxBrr[] = new long[arr.length - k + 1];
		long max = arr[0], secondMax = arr[0], maxOfPosition = 0, secondMaxOfPosition = 0;
		int j = 0;
		if (k == 1) {
			for (int i = 0; i < arr.length; i++) {
				maxBrr[i] = arr[i];
			}
		} else {
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > max) {
					max = arr[i];
					maxOfPosition = i;
				}
				if (arr[i] > secondMax && arr[i] < max) {
					secondMax = arr[i];
					secondMaxOfPosition = i;
				}
				if ((i - j + 1) % k == 0 && j < maxBrr.length) {
					maxBrr[j++] = max;
					if ((i + 1 - k) == maxOfPosition) {
						max = secondMax;
						maxOfPosition = secondMaxOfPosition;
						secondMax = 0;
						secondMaxOfPosition = 0;
					}
				}

			}
		}
		for (long i : maxBrr) {
			System.out.println(i);
		}
	}

}
