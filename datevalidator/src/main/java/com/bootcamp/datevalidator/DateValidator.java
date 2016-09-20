package com.bootcamp.datevalidator;

import java.util.Scanner;

import com.bootcamp.datevalidator.exception.BadDay;
import com.bootcamp.datevalidator.exception.BadMonth;

public class DateValidator {

	enum Month {
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
	}

	private Scanner scanner;
	private int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public DateValidator() {
		this.scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		DateValidator instance = new DateValidator();
		while (true) {
			try {
				String month = instance.promptAndReadMonth();
				if ("quit".equalsIgnoreCase(month)) {
					System.out.println("Exiting application");
					break;
				}
				int day = instance.promptAndReadDay();
				instance.validateMonthAndDay(month, day);
				System.out.println("Values validated");
			} catch (BadMonth bm) {
				System.out.println(bm.getMessage());
				if (bm.getCause() != null) {
					System.out.println(bm.getCause().getMessage());
				}
			} catch (BadDay bd) {
				System.out.println(bd.getMessage());
			} catch (Exception exe) {
				System.out.println(exe);
			}
		}
		instance.scanner.close();
	}

	private String promptAndReadMonth() {
		System.out.println("Enter month :");
		String month = scanner.nextLine();
		return month;
	}

	private int promptAndReadDay() {
		System.out.println("Enter day :");
		int day = Integer.parseInt(scanner.nextLine());
		return day;
	}

	private void validateMonthAndDay(String month, int day) throws BadMonth, BadDay {
		try {
			Month.valueOf(month.toUpperCase());
		} catch (IllegalArgumentException iae) {
			throw new BadMonth("Invalid month", iae);
		}
		int monthIndex = findMonthIndex(month);
		if (day < 0 || day > monthDays[monthIndex]) {
			throw new BadDay("Invalid day for the provided month");
		}
	}

	private int findMonthIndex(String inMonth) {
		int index = -1;
		for (Month month : Month.values()) {
			if (inMonth.equals(month)) {
				return ++index;
			}
			++index;
		}
		return index;
	}
}
