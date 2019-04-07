package com.prashant.datastrutures.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LargestIncreasingSequence {

	// ****************************
	// Get maximum of two values
	// ****************************

	private int maximum(int a, int b) {

		return a < b ? b:a;
	}



	public int LD(int[] arr, int n) {
		List<Integer> list  = new ArrayList<>();
		if (n  == 0)
			return 0;
		for (int i = 0; i < n; i++) {
			list.add(1);
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i-1; j++) {
				if (arr[i] > arr[j] && list.get(i) < list.get(j)+1) {
					list.set(i,list.get(j)+1);
				}
			}
		}
		return list.stream().max(Integer::compareTo).get();
	}
}

public class LIS {
	public static void main(String[] args) {

		LargestIncreasingSequence largestIncreasingSequence = new LargestIncreasingSequence();
		System.out.println("Largest Common Subsequence: " + largestIncreasingSequence.LD(new int [] {10,22,9,33,21,50,41,60}, 8));
		//System.out.println("Largest Common Subsequence: " + largestIncreasingSequence.LD("longest", "stone"));
	}
}