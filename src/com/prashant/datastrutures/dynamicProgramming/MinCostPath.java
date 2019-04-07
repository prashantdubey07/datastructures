package com.prashant.datastrutures.dynamicProgramming;

import java.util.Arrays;

public class MinCostPath {

	public static void main(String[] args) {

		int matrix[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		long x =  System.nanoTime();
		System.out.println(new MinCost().minCost(matrix, 2, 2));
		long z =  System.nanoTime();
		System.out.println(new MinCostWithMemoization().minCost(matrix, 2, 2));
		long y =  System.nanoTime();
		System.out.println(new MinCostWithMemoization().minCost(matrix, 2, 2));
		long p =  System.nanoTime();
		System.out.println(new MinCostWithMemoization().minCost(matrix, 1, 1));
		long q =  System.nanoTime();
		System.out.println((z-x) +" "+ (y-z) +" "+(p-y)+" "+(q-p));
	}
}

class MinCost {
	// ****************************
	// Get minimum of three values
	// ****************************

	private int minimum(int a, int b, int c) {
		if (a < b)
			return (a < c) ? a : c;
		else
			return (b < c) ? b : c;
	}

	public int minCost(int matrix[][], int m, int n) {
		if (m == 0 && n == 0) {
			return matrix[m][n];
		}
		if (m < 0 || n < 0) {
			return Integer.MAX_VALUE;
		}
		return minimum(minCost(matrix, m - 1, n), minCost(matrix, m - 1, n - 1), minCost(matrix, m, n - 1))
				+ matrix[m][n];
	}
}

class MinCostWithMemoization {
	// ****************************
	// Get minimum of three values
	// ****************************
	static int dp[][];

	private int minimum(int a, int b, int c) {

		if (a < b)
			return (a < c) ? a : c;
		else
			return (b < c) ? b : c;
	}

	public void buildDp(int matrix[][], int m, int n){
		if(dp == null) {
			dp = new int[m + 1][n + 1];
			dp[0][0] = matrix[0][0];

			for (int i = 1; i <= m; i++)
				dp[i][0] = dp[i - 1][0] + matrix[i][0];

			for (int j = 1; j <= n; j++)
				dp[0][j] = dp[0][j - 1] + matrix[0][j];

			for (int i = 1; i <= m; i++)
				for (int j = 1; j <= n; j++)
					dp[i][j] = minimum(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
		}

	}
	public int minCost(int matrix[][], int m, int n) {
		buildDp(matrix, m, n);
		Arrays.stream(dp).forEach(p -> System.out.println(Arrays.toString(p)));
		return dp[m][n];
	}
}