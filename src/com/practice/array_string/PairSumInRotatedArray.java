package com.practice.array_string;

public class PairSumInRotatedArray {

	public static void main(String[] args) {

		int arr[] = { 11, 15, 6, 8, 9, 10 };

		int size = arr.length;

		int sum = 16;

		int pivot = -1;

		if (size >= 1) {
			pivot = findPivot(arr, 0, size - 1, size);
			System.out.println("Pivot: " + pivot);
		}
		
		// move left with (size+pivot-1)%size if sum acquired is greater
		// move right with (size+pivot+1)%size if sum acquired is less

	}

	private static int findPivot(int[] arr, int low, int high, int size) {

		if (high < low)
			return size;

		if (high == low)
			return low;

		int mid = (low + high) / 2;

		if (arr[mid] < arr[(size + mid - 1) % size] && arr[mid] < arr[(size + mid + 1) % size])
			return (size + mid - 1) % size;

		if (arr[mid] > arr[(size + mid - 1) % size] && arr[mid] > arr[(size + mid + 1) % size])
			return mid;

		if (arr[mid] > arr[(size + mid - 1) % size] && arr[mid] < arr[(size + mid + 1) % size])
			return findPivot(arr, low, mid - 1, size);
		else
			return findPivot(arr, mid + 1, high, size);

	}

}
