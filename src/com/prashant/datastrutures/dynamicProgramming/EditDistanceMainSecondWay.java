package com.prashant.datastrutures.dynamicProgramming;

class Distance {

	// ****************************
	// Get minimum of three values
	// ****************************

	private int minimum(int a, int b, int c) {

		return a < b ? (a < c ? a : c < b ? c : b) : (c < a ? c : a < b ? a : b);
	}

	// *****************************
	// Compute Levenshtein distance
	// *****************************

	public int LD(String s, String t) {
		int dp[][] = new int[s.length() + 1][t.length() + 1];
		int cost = 0;
		if (s.length() == 0)
			return t.length();
		if (t.length() == 0)
			return s.length();
		for (int i = 0; i <= s.length(); i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= t.length(); i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					cost = 0;
				} else {
					cost = 1;
				}
				dp[i][j] = minimum(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + cost;
			}
		}
		return dp[s.length()][t.length()];
	}

}

public class EditDistanceMainSecondWay {
	public static void main(String[] args) {

		Distance distance = new Distance();
		System.out.println("Edit Distance: " + distance.LD("pqqrst", "qqttps"));
	}
}