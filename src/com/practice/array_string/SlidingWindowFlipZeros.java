package com.practice.array_string;

public class SlidingWindowFlipZeros {

	static int arr[] = new int[] {0, 0, 0, 1};

	public static void main(String[] args) {

		int m = 4;
		System.out.println("Indexes of zeroes to be flipped are ");

		findZeroes(m);
	}

	private static void findZeroes(int m) {

		int n = m;
		int maxSoFar = 0;
		int tempMax = 0;
		int wL = 0, wR = 0;
		int wO = 0;
		int l = 0, r = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 1) {
				wR++;
			}

			if (n <= 0 && arr[i] == 0) {
				tempMax = wR - wL;
				if(maxSoFar < tempMax) {
					maxSoFar = tempMax;
					l = wL;
					r = wR;
					tempMax =0;
				}
				if (wO + 1 <= arr.length - 1) {
					wL = wO + 1;
					n = m;
				}
			}
			if (n > 0 && arr[i] == 0) {
				wR++;
				n--;
				if (n == 0)
					wO = i;
			}

			if (i == arr.length-1) {
				tempMax = wR - wL;
				if(maxSoFar < tempMax) {
					maxSoFar = tempMax;
					l = wL;
					r = wR;
				}
			}

		}

		System.out.println("wL: " + wL + " wR: " + wR + " l: " + l + " r: " + r + " maxCount: " + maxSoFar);

		for (int j = l; j < arr.length && j < r; j++) {

			if (arr[j] == 0)
				System.out.println(j);
		}

	}

}
