
package com.practice.array_string;

/**
 * tausif.akram
 */

public class AnagramString {

	static boolean visited[] = new boolean[256];

	public static void main(String[] args) {
		String str = "aba";
		generateAnagram(str, 0, str.length() - 1);

	}

	private static void generateAnagram(String str, int start, int end) {

		if (start == end) {
			System.out.println(str);
			return;
		} else {
			for (int i = start; i <= end; i++) {

				if (!visited[str.charAt(i)]) {
					str = swap(str, start, i);
					generateAnagram(str, start + 1, end);
					str = swap(str, i, start);
					visited[str.charAt(i)] = true;
				}

			}
		}

	}

	private static String swap(String str, int i, int j) {

		char temp;
		char strCharArr[] = str.toCharArray();
		temp = strCharArr[i];
		strCharArr[i] = strCharArr[j];
		strCharArr[j] = temp;

		return String.valueOf(strCharArr);

	}

}
