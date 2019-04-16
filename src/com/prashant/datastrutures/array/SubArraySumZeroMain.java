package com.prashant.datastrutures.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySumZeroMain {
	// Function to print all subarrays in the array which
	// has sum 0
	static Map<Integer, List<Integer>> findSubArrays(int[] arr, int n) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, List<Integer>> mapOfSum = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				if (map.get(0) != null)
					map.get(0).add(i);
				else
					map.put(0, temp);
			}

			List<Integer> list = new ArrayList<>();
			if (mapOfSum.containsKey(sum)) {
				list = 	mapOfSum.get(sum);
				for (int j = 0; j < mapOfSum.get(sum).size(); j++) {
					
					if (map.get(list.get(j) + 1) != null)
						map.get(list.get(j) + 1).add(i);
					else
					{
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(i);
						map.put(list.get(j) + 1, temp);
					}
					
				}
			}
			list.add(i);
			mapOfSum.put(sum, list);
		}

		return map;
	}

	static void print(Map<Integer, List<Integer>> map) {
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int i = entry.getValue().size();
			int c=0;
			while (i-- > 0) {
				System.out.println("Subarray found from Index " + entry.getKey() + " to " + entry.getValue().get(c++));
			}
			
		}
	}

	public static void main(String args[]) {
		int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		int n = arr.length;
		Map<Integer, List<Integer>> map = findSubArrays(arr, n);
		if (map.size() == 0)
			System.out.println("No subarray exists");
		else
			print(map);
	}
}