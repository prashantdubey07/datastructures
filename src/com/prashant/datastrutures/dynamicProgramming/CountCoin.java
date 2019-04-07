package com.prashant.datastrutures.dynamicProgramming;

public class CountCoin {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3}; 
        int m = arr.length; 
        System.out.println( CountMain.count(arr, m, 4)); 
	}

}

class CountMain {
	static int count(int S[], int m, int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (m <=0 && n >= 1)
			return 0;
		return count(S, m-1,n)+count(S,m,n-S[m-1]);
	}
}
class CountMainWithMemoization {
	static int count(int S[], int m, int n) {
		int table[] = new int[n+1]; 
		table[0] = 1;
		
		for(int i =0; i< m ;i++)
		{
			for(int j =S[i];j<= n;j++ ) {
				table[j] += table[j-S[j]];
			}
		}
		return table[n];
	}
}
