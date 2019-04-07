package com.prashant.datastrutures.dynamicProgramming;

class LargestCommonSequence {

	// ****************************
	// Get maximum of two values
	// ****************************

	private int maximum(int a, int b) {

		return a < b ? b:a;
	}



	public int LD(String s, String t) {
		int dp[][] = new int[s.length() + 1][t.length() + 1];
		if (s.length() == 0)
			return t.length();
		if (t.length() == 0)
			return s.length();
		for (int i = 0; i <= s.length(); i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= t.length(); i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = 1 + (dp[i - 1][j-1]);
				} else {
					dp[i][j] = maximum(dp[i - 1][j], dp[i][j - 1]);
				}
				
			}
		}
		return dp[s.length()][t.length()];
	}

}

public class LCS {
	public static void main(String[] args) {

		LargestCommonSequence largestCommonSequence = new LargestCommonSequence();
		System.out.println("Largest Common Subsequence: " + largestCommonSequence.LD("abdc", "bd"));
		System.out.println("Largest Common Subsequence: " + largestCommonSequence.LD("longest", "stone"));
	}
}