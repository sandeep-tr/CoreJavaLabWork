package com.bootcamp.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reading {

	private String dayOfTheWeek;
	private int hourOfTheDay;
	private int temperature;
	private int windSpeed;

	public Reading(String line) {
		String[] elements = line.split(", ");
		dayOfTheWeek = elements[0];
		hourOfTheDay = Integer.parseInt(elements[1]);
		temperature = Integer.parseInt(elements[2]);
		windSpeed = Integer.parseInt(elements[3]);
	}

	public static void main(String[] args) {
		try (BufferedReader br = Files.newBufferedReader(Paths.get("src/main/resources/weather.csvx"))) {
			Reading[] readings = new Reading[12];
			for (int i = 0; i < readings.length; i++) {
				readings[i] = new Reading(br.readLine());
			}
			iterateReadingArrayAndPrint(readings);
		} catch (IOException ioe) {
			System.out.println("IOException in main - " + ioe);
		}
	}

	private static void iterateReadingArrayAndPrint(Reading[] readings) {
		for (int i = 0; i < readings.length; i++) {
			System.out.println(readings[i].getTime() + " was " + readings[i].rateTemperature());
		}
	}

	private String rateTemperature() {
		String rating = null;
		if (temperature < 55) {
			rating = "cold";
		} else if (temperature < 65) {
			rating = "mild";
		} else if (temperature < 80) {
			rating = "warm";
		} else {
			rating = "hot";
		}
		return rating;
	}

	private String getTime() {
		String time = null;
		switch (hourOfTheDay) {
		case 9:
			time = "morning";
			break;
		case 15:
			time = "afternoon";
			break;
		case 21:
			time = "evening";
			break;
		default:
			time = "unidentified";
			break;
		}
		return dayOfTheWeek + " " + time;
	}
}
