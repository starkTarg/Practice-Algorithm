package com.practice.array_string;

public class KMP_StringPatternMatching {

	public static void main(String[] args) {

		String text = "abxabcabcaby";
		String pattern = "abcabb"; // "abcdabca";

		int[] prefix = patternPrefix(pattern);

		for (int i = 0; i < prefix.length; i++) {
			System.out.print(prefix[i] + " ,");
		}
		
		System.out.println("\n");

		boolean isPatternExist = patternExist(text, pattern, prefix);
		
		System.out.println("Does Pattern exist : " + isPatternExist);

	}

	private static boolean patternExist(String text, String pattern, int[] prefix) {

		int m = 0;
		int n = 0;
		boolean exist = true;

		while (n < pattern.length() && m < text.length()) {

			if (text.charAt(m) == pattern.charAt(n)) {
				m++;
				n++;
				exist =true;
			} else {
				if (n != 0) {
					n = prefix[n - 1];
				} else {
					m++;
				}
				exist =false;
			}

		}

		return exist;
	}

	private static int[] patternPrefix(String pattern) {

		String[] patternArr = pattern.split("");
		int prefixArr[] = new int[patternArr.length];

		int i = 1;
		int j = 0;

		while (i < patternArr.length && j < patternArr.length) {

			if (patternArr[j].equals(patternArr[i])) {
				prefixArr[i] = j + 1;
				i++;
				j++;
			} else {
				if (j != 0) {
					j = prefixArr[j - 1];
				} else {
					prefixArr[i] = 0;
					i++;
				}

			}

		}

		return prefixArr;
	}

}
