package com.practice.array_string;

// code for kth smallest element in an array
// https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/

public class KthSmallestLargestQuickSelect {

	public static void main(String[] args) {

		int arr[] = { 12, 3, 5, 7, 4, 19, 26 };// {7,10,4,3,20,15};
		// {12, 3, 5, 7, 4, 19, 26};
		int k = 3;
		int result = findKthSmallest(arr, 0, arr.length - 1, k);

		System.out.println("" + k + " th smallest element is: " + result);

	}

	private static int findKthSmallest(int[] arr, int left, int right, int k) {

		if (left == right)
			return arr[left];

		int split = partition(arr, left, right);

		int length = split - left + 1;
		if (length == k) {
			return arr[split];
		} else if (length > k) {
			return findKthSmallest(arr, left, split - 1, k);
		} else {
			return findKthSmallest(arr, split + 1, right, k - length);
		}

	}

	private static int partition(int[] arr, int left, int right) {

		int pivot = arr[left];
		int leftMark = left + 1;
		int rightMark = right;

		while (true) {

			while (leftMark < right && arr[leftMark] < pivot) {
				leftMark++;
			}

			while (rightMark > left && arr[rightMark] > pivot) {
				rightMark--;
			}

			if (leftMark >= rightMark) {
				break;
			} else {
				int temp = arr[leftMark];
				arr[leftMark] = arr[rightMark];
				arr[rightMark] = temp;
			}

		}

		int temp = arr[left];
		arr[left] = arr[rightMark];
		arr[rightMark] = temp;

		return rightMark;

	}
}
