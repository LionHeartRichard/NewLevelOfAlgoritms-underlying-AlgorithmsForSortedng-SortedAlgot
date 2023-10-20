package com.isaev.algoritms.underlying;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MergeSort {

	public static void mergeSort(int[] mas, int n) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] leftMas = new int[mid];
		int[] rightMas = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			leftMas[i] = mas[i];
		}
		for (int i = mid; i < n; i++) {
			rightMas[i - mid] = mas[i];
		}

		mergeSort(leftMas, mid);
		mergeSort(rightMas, n - mid);
		merge(mas, leftMas, rightMas, mid, n - mid);
	}

	private static void merge(int[] mas, int[] leftMas, int[] rightMas, int l, int r) {
		int i = 0, j = 0, k = 0;
		while (i < l && j < r) {
			if (leftMas[i] <= rightMas[j]) {
				mas[k++] = leftMas[i++];
			} else {
				mas[k++] = rightMas[j++];
			}
		}
		while (i < l) {
			mas[k++] = leftMas[i++];
		}
		while (j < r) {
			mas[k++] = rightMas[j++];
		}
	}

	@Test
	public void positiveTest() {
		int[] actual = { 5, 1, 6, 2, 3, 4 };
		int[] expected = { 1, 2, 3, 4, 5, 6 };
		MergeSort.mergeSort(actual, actual.length);
		assertArrayEquals(expected, actual);
	}
}
