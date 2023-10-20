package com.isaev.algoritms.underlying.oldtasksolution;

import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	public static int[] bruteForce(int[] mas, int k) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = i + 1; j < mas.length; j++) {
				if (mas[i] + mas[j] == k) {
					return new int[] { mas[i], mas[j] };
				}
			}
		}
		return null;
	}

	public static int[] searchSolutionTroughtSet(int[] mas, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < mas.length; i++) {
			int numberToFind = k - mas[i];
			if (set.contains(numberToFind)) {
				return new int[] { numberToFind, mas[i] };
			}
			set.add(mas[i]);
		}

		return null;
	}

	public static int[] twoPoint(int[] mas, int k) {
		Arrays.sort(mas);
		int l = 0, r = mas.length - 1;
		while (l < r) {
			int sum = mas[l] + mas[r];
			if (sum == k) {
				return new int[] { mas[l], mas[r] };
			}
			if (sum < k) {
				l++;
			} else {
				r--;
			}
		}
		return null;
	}

	public static int[] searchIndexSolutionTwoPoint(int[] mas, int target) {
		int[] arr = Arrays.copyOf(mas, mas.length);
		int[] res = twoPoint(mas, target);
		int i = -1, j = -1;
		if (res != null) {
			for (int k = 0; k < arr.length; k++) {
				if (res[0] == arr[k]) {
					i = k;
				}
				if (res[1] == arr[k]) {
					j = k;
				}
				if (i > -1 && j > -1) {
					return new int[] { j, i };
				}
			}

		}
		return null;
	}

	@Test
	public void positiveTestSearchSolutionTroughtSet() {
		int[] actual = { 2, 54, 23, 50, 12, 0, 12 };
		int[] expected = { 23, 12 };
		actual = searchSolutionTroughtSet(actual, 35);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void positiveTestTwoPoint() {
		int[] actual = { 0, 3, 8, 23, -4, 25, 78 };
		int[] expected = { -4, 3 };
		actual = twoPoint(actual, -1);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void positiveTestSearchIndexSolutionTwoPoint() {
		int[] actual = { 0, 3, 8, 23, -4, 25, 78 };
		int[] expected = { 6, 1 };
		actual = searchIndexSolutionTwoPoint(actual, 81);
		assertArrayEquals(expected, actual);
	}

}
