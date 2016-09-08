package com.bootcamp.converter;

import java.util.Scanner;

public class DataAnalyzer {

	float mean;
	int min, max;
	Scanner scanner;

	public static void main(String[] args) {

		DataAnalyzer instance = new DataAnalyzer();
		try {
			instance.scanner = new Scanner(System.in);

			int[] array = instance.readAndPopulateArray();
			instance.analyzeData(array);
			instance.printAnalysedData();
		} finally {
			if (instance.scanner != null) {
				instance.scanner.close();
			}
		}
	}

	private int[] readAndPopulateArray() {
		int arraySize = promptAndReadArraySize();
		int[] array = promptAndReadArrayElements(arraySize);
		return array;
	}

	private int promptAndReadArraySize() {
		System.out.println("Enter desired array size");
		String line = scanner.nextLine();
		int arraySize = Integer.parseInt(line);
		return arraySize;
	}

	private int[] promptAndReadArrayElements(int arraySize) {
		System.out.println("Keep on entering array elements");
		int[] array = new int[arraySize];
		int counter = 0;
		while (counter < arraySize) {
			String line = scanner.nextLine();
			int element = Integer.parseInt(line);
			array[counter++] = element;
		}
		return array;
	}

	private void analyzeData(int[] array) {
		findAndSetMean(array);
		findAndSetMin(array);
		findAndSetMax(array);
	}

	private void findAndSetMean(int[] array) {
		float sum = 0;
		for (int item : array) {
			sum += item;
		}
		mean = sum / array.length;
	}

	private void findAndSetMin(int[] array) {
		min = Integer.MAX_VALUE;
		for (int item : array) {
			if (item < min) {
				min = item;
			}
		}
	}

	private void findAndSetMax(int[] array) {
		max = Integer.MIN_VALUE;
		for (int item : array) {
			if (item > max) {
				max = item;
			}
		}
	}

	private void printAnalysedData() {
		System.out.println("mean - " + mean);
		System.out.println("min - " + min);
		System.out.println("max - " + max);
	}
}
