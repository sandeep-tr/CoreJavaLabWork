package com.bootcamp.methodarguments;

public class MainVarArgs {
	private static String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten" };

	public static void main(String[] args) {

		addUp(3.2, 2.2);
		addUp(1, 4);
		addUp("one", "three");
		addUp(2, 3.5);
		// -- addUp(1, "three");
	}

	private static void addUp(int... values) {
		int sum = 0;
		for (int number : values) {
			sum += number;
		}
		System.out.println("Int version invoked - " + sum);
	}

	private static void addUp(double... values) {
		double sum = 0;
		for (double number : values) {
			sum += number;
		}
		System.out.println("Double version invoked - " + sum);
	}

	private static void addUp(String... values) {
		int sum = 0;
		for (String number : values) {
			sum += toNumber(number);
		}
		System.out.println("String version invoked - " + sum);
	}

	private static int toNumber(String text) {
		for (int i = 0; i < numbers.length; i++) {
			if (text.equals(numbers[i])) {
				return i;
			}
		}
		return -1;
	}
}
