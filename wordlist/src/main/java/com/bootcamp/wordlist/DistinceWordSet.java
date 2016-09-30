package com.bootcamp.wordlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DistinceWordSet {

	public static void main(String[] args) {
		DistinceWordSet instance = new DistinceWordSet();
		String filePath = "src\\main\\resources\\prideandprejudice.txt";
		Set<String> distinctWords = instance.readFileAndWords(filePath);
		instance.printWords(distinctWords);
	}

	private Set<String> readFileAndWords(String filePath) {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
			return readLineAndAddWords(reader);
		} catch (IOException e) {
			System.out.println("IOException while reading file - " + e);
		}
		return Collections.emptySet();
	}

	private Set<String> readLineAndAddWords(BufferedReader reader) throws IOException {
		Set<String> distinctWords = new HashSet<>();
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] words = line.split("\\W+");
			for (String word : words) {
				distinctWords.add(word.toLowerCase());
			}
		}
		return distinctWords;
	}

	private void printWords(Set<String> distinctWords) {
		System.out.println(distinctWords);
	}

}
