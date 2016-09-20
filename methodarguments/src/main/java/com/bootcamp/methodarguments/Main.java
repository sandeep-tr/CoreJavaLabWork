package com.bootcamp.methodarguments;

public class Main {
	private static String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten" };

	public static void main(String[] args) {

		addUp(3.2, 2.2);
		addUp(1, 4);
		addUp("one", "three");
		addUp(2, 3.5);
		// -- addUp(1, "three");
	}

	private static void addUp(int a, int b) {
		System.out.println("Int version invoked - " + (a + b));
	}

	private static void addUp(double a, double b) {
		System.out.println("Double version invoked - " + (a + b));
	}

	private static void addUp(String a, String b) {
		System.out.println("String version invoked - " + (toNumber(a) + toNumber(b)));
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
