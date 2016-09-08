package com.bootcamp.converter;

import java.util.Scanner;

public class FahrenheitConverter {

	public static void main(String[] args) {
		System.out.println("Enter a Fahrenheit temperature");
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			double fahrenheit = Double.valueOf(line);
			double celsius = 5 * (fahrenheit - 32) / 9;
			System.out.println("Celsius after conversion - " + celsius);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
