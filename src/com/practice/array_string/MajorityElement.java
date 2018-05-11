
package com.practice.array_string;

/**
 * tausif.akram
 */

public class MajorityElement {

	public static void main(String[] args) {

		int arr[] = {1, 3,3,3,2,2,5,5,5,5,6,6,8,8,8,8,8, 1, 2, 9,12,13,3, 3, 3,13,14,15,16,17};
		int result = findMajorityElement(arr);

		System.out.println("Mpjority Element :: " + result);
	}

	private static int findMajorityElement(int[] arr) {

		int majorityEle = arr[0];
		int count = 1;

		for (int i = 1; i < arr.length; i++) {

			if (count == 0) {
				majorityEle = arr[i];
				count++;
			}
			if (arr[i] == arr[i - 1]) {
				count++;
			} else {
				count--;
			}
		}

		count = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == majorityEle)
				count++;
		}

		if (count > (arr.length / 2))
			return majorityEle;
		else
			return -1;
	}

}
