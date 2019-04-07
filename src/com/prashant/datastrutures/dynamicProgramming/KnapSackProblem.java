package com.prashant.datastrutures.dynamicProgramming;

public class KnapSackProblem {

	public static void main(String[] args) {

		int profit[] = new int[] { 60, 100, 120 };
		int wieght[] = new int[] { 10, 20, 30 };

		int W = 50;
		int n = wieght.length;

		KnapSack knapSack = new KnapSack();
		System.out.println(knapSack.findKnapSack(W, n, wieght, profit));
		System.out.println(knapSack.FindKnapSackMemoization(W, n, wieght, profit));
	}

}

class KnapSack {
	private int maximum(int a, int b) {

		return a < b ? b : a;
	}

	public int findKnapSack(int c, int n, int[] w, int[] p) {

		if (c <= 0 || n <= 0)
			return 0;
		if (w[n - 1] > c) {
			return findKnapSack(c, n - 1, w, p);
		} else
			return maximum(findKnapSack(c - w[n - 1], n - 1, w, p) + p[n - 1], findKnapSack(c, n - 1, w, p));
	}

	public int FindKnapSackMemoization(int W, int n, int wt[], int val[]) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = maximum(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}
		return K[n][W];
	}
}
