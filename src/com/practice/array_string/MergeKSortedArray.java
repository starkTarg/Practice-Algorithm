package com.practice.array_string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {
	public static void main(String[] args) {
		int[][] arr = {
				{ 1, 3, 5, 7 },
				{ 2, 4, 6, 8 },
				{ 0, 9, 10, 11 }
				};
		int k = 3;
		int n = 4;
		int[] res = mergeKSortedArrays(arr, k, n);
		System.out.println(Arrays.toString(res));
	}

	// k=3, n=4
	static int[] mergeKSortedArrays(int[][] arr, int k, int n) {
		int[] result = new int[n * k];
		if (k <= 1) {
			return arr[0];
		}
		PriorityQueue<PQNode> pq = new PriorityQueue<>(k, new Comparator<PQNode>() {
			@Override
			public int compare(PQNode o1, PQNode o2) {
				return o1.data - o2.data;
			}
		});

		for (int i = 0; i < k; i++) {
			pq.add(new PQNode(arr[i][0], 1, i));
		}

		int j = 0;
		while (!pq.isEmpty()) {
			PQNode node = pq.poll();
			result[j] = node.data;
			if (node.nextIndex < n) {
				pq.add(new PQNode(arr[node.arrIndex][node.nextIndex], node.nextIndex + 1, node.arrIndex));
			}
			j++;
		}
		return result;
	}
}

class PQNode {
	public int data;
	public int nextIndex;
	public int arrIndex;

	public PQNode(int d, int ni, int ai) {
		this.data = d;
		this.nextIndex = ni;
		this.arrIndex = ai;
	}
}