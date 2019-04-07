package com.prashant.datastrutures.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueCapDynamicProgrammingBitMasking {
	static Map<Integer, List<Integer>> capMap = new HashMap<>(101);
	static int arr[][] = new int[1025][101];
	static int maxNumberForNumberOfPersonBit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfPerson = Integer.parseInt(br.readLine());
		maxNumberForNumberOfPersonBit = (1 << numberOfPerson) - 1;
		// System.out.println(allmask);
		String line = "";
		for (int i = 0; i < numberOfPerson; i++) {
			line = br.readLine();
			String arr[] = line.split(" ");
			for (String str : arr) {
				int x = Integer.parseInt(str);
				if (capMap.get(x) != null)
					capMap.get(x).add(i);
				else {
					List<Integer> tempList = new ArrayList<>();
					tempList.add(i);
					capMap.put(x, tempList);
				}
			}

		}
		// fill map with list of no values for other caps so it should not give error
		for (int i = 0; i < 101; i++) {
			if (capMap.get(i) == null) {
				List<Integer> tempList = new ArrayList<>();
				capMap.put(i, tempList);
			}
		}

		// fill the dp with -1
		for (int[] is : arr) {
			for (int i = 0; i < is.length; i++) {
				is[i] = -1;
			}
		}
		int countWays = countWays(0, 1);
		System.out.println(countWays);
	}

	static int countWays(int mask, int i) {
		if (mask == maxNumberForNumberOfPersonBit)
			return 1;
		else if (i > 100) {
			return 0;
		}
		if (arr[mask][i] != -1)
			return arr[mask][i];

		// don't take that person
		int ways = countWays(mask, i + 1);

		// number of person for the particular cap
		int size = capMap.get(i).size();

		for (int j = 0; j < size; j++) {
			// check whether that guy has cap if no then assign him cap and move to next cap
			// and cap
			if ((mask & (1 << capMap.get(i).get(j))) != 0)
				continue;
			else
				ways += countWays(mask | (1 << capMap.get(i).get(j)), i + 1);
		}
		arr[mask][i] = ways;
		return ways;
	}
}