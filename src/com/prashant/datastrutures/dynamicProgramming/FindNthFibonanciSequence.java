package com.prashant.datastrutures.dynamicProgramming;

public class FindNthFibonanciSequence {

	
	//log (n)
	public static void main(String[] args) {
		/*
		 * Scanner sc = new Scanner(System.in); long findNumber = sc.nextInt();
		 */

		FibonancyFInder fibonancyFInder = new FibonancyFInder();
		for (int i = 0; i < 15; i++) {
			System.out.println(fibonancyFInder.findFib(i));
		}

	}
}

class FibonancyFInder {
	private final long[][][] exponents;

	public FibonancyFInder() {
		super();
		this.exponents = new long[64][2][2];
		this.exponents[0] = new long[][] { { 1, 1 }, { 1, 0 } };
		for (int i = 1; i < exponents.length; i++) {
			exponents[i] = square(exponents[i - 1]);
        }
    }

    private long[][] square( long[][] arr) {
        return multiply(arr, arr);
    }

	// matrix multiplication
	public long[][] multiply(long arr[][], long brr[][]) {
		long result[][] = new long[arr[0].length][brr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < brr[0].length; j++) {
				for (int k = 0; k < arr[i].length; k++) {
					result[i][j] += arr[i][k] * brr[k][j];
				}
			}
		}
		return result;
	}

	public long findFib(int n) {
		long result[][] = null;
		if (n < 0)
			return 0;
		else if (n == 0 || n == 1)
			return 1;
		else {
			result = binaryExponentiation(n - 1);
			return result[0][0] + result[0][1];
		}
			
	}
	// binary exponentiation
	public long[][] binaryExponentiation(int n) {
		long result[][] = new long[][] { { 1, 0 }, { 0, 1 } };
		for (int i = 31; i >= 0; i--) {
			if ((n & (1 << i)) != 0) {
				result = multiply(result, exponents[i]);
			}
		}
		return result;
	}
}
