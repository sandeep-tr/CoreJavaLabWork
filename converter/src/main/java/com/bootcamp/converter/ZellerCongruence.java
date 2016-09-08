package com.bootcamp.converter;

import java.util.Scanner;

public class ZellerCongruence {

	Scanner scanner = null;

	public static void main(String[] args) {

		ZellerCongruence instance = new ZellerCongruence();
		try {
			instance.scanner = new Scanner(System.in);
			boolean timeToQuit = false;
			while (!timeToQuit) {
				String command = instance.promptAndReadDay();
				timeToQuit = "quit".equalsIgnoreCase(command);
				if (!timeToQuit) {
					int day = Integer.parseInt(command);
					int month = instance.promptAndReadMonth();
					month = instance.checkAndModifyMonth(month);
					int year = instance.promptAndReadYear();
					year = instance.checkAndModifyYear(month, year);

					int weekDayCode = instance.calculateWeekDayCode(day, month, year);
					String weekDay = instance.convertWeekDayCode(weekDayCode);
					System.out.println("Weekday - " + weekDay);
				}
			}
		} finally {
			if (instance.scanner != null) {
				instance.scanner.close();
			}
		}
	}

	private String promptAndReadDay() {
		System.out.println("Enter day of a month");
		String day = scanner.nextLine();
		return day;
	}

	private int promptAndReadMonth() {
		System.out.println("Enter a month");
		String line = scanner.nextLine();
		int month = Integer.parseInt(line);
		return month;
	}

	private int promptAndReadYear() {
		System.out.println("Enter an year");
		String line = scanner.nextLine();
		int year = Integer.parseInt(line);
		return year;
	}

	private int checkAndModifyMonth(int month) {
		if (month > 0 && month < 3) {
			return month + 12;
		}
		return month;
	}

	private int checkAndModifyYear(int month, int year) {
		if (month > 0 && month < 3) {
			return year - 1;
		}
		return year;
	}

	private int calculateWeekDayCode(int day, int month, int year) {

		int a = (13 * (month + 1) / 5);
		int b = (year / 4);
		int c = (6 * (int) (year / 100));
		int d = (year / 400);

		int weekDayCode = (a + b + c + d + year + day) % 7;
		return weekDayCode;
	}

	private String convertWeekDayCode(int code) {
		System.out.println("code" + code);
		String weekDay = null;
		switch (code) {
		case 2:
			weekDay = "Monday";
			break;
		case 3:
			weekDay = "Tuesday";
			break;
		case 4:
			weekDay = "Wednesday";
			break;
		case 5:
			weekDay = "Thursday";
			break;
		case 6:
			weekDay = "Friday";
			break;
		case 0:
			weekDay = "Saturday";
			break;
		case 1:
			weekDay = "Sunday";
			break;
		default:
			weekDay = "unidentified day";
		}
		return weekDay;
	}
}
