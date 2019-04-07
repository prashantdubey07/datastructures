package com.prashant.datastrutures.dynamicProgramming;

import java.util.Arrays;

public class EggFloorDropSolving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new EggFloorDropSolving().solveUsingDp(8, 4));
	}

	public int solveUsingDp(int n, int k) {
		int results[][] = new int[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            results[i][1] = i;
        }
        for (int i = 0; i < k + 1; i++) {
            results[1][i] = 1;
        }
        for(int i=2; i< n+1; i++)
        {
        	for(int j=2; j< k+1; j++)
        	{
        		results[i][j] = Integer.MAX_VALUE;
        		for(int x = 1; x<i; x++ ) {
        			int saved = results[i - x][j];
        			int broken = results[x-1][j-1];
        			int count = Math.max(saved, broken)+1;
        			if(results[i][j] > count)
        				results[i][j] = count;
        		}
        	}
        }
        for (final int[] a : results) {
            System.out.println(Arrays.toString(a));
        }
        return results[n][k];
    }
}
