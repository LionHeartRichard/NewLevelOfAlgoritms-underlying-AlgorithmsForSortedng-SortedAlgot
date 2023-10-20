package com.isaev.algoritms.underlying;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class QuickSort {

	public static void quickSort(int[] mas, int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(mas, begin, end);
			quickSort(mas, begin, partitionIndex - 1);
			quickSort(mas, partitionIndex + 1, end);
		}
	}

	private static int partition(int[] mas, int begin, int end) {
		int pivot = mas[end];
		int i = begin - 1;

		for (int j = begin; j < end; j++) {

			if (mas[j] <= pivot) {
				i++;

				int swapTemp = mas[i];
				mas[i] = mas[j];
				mas[j] = swapTemp;
			}
		}

		int swapTemp = mas[i + 1];
		mas[i + 1] = mas[end];
		mas[end] = swapTemp;

		return i + 1;
	}

	@Test
	public void positiveTestQuickSort() {
		int[] actual = { 0, -2, 5, 0, 7, -3, 28, 19, 3, -2, 14 };
		int[] expected = { -3, -2, -2, 0, 0, 3, 5, 7, 14, 19, 28 };

		QuickSort.quickSort(actual, 0, actual.length - 1);
		assertArrayEquals(expected, actual);
	}

}
