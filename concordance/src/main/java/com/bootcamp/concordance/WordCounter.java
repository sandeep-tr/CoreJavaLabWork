package com.bootcamp.concordance;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
	
	public static void main(String[] args) {
		WordCounter instance = new WordCounter();
		String filePath = "src\\main\\resources\\prideandprejudice.txt";
		Map<String, Integer> distinctWords = instance.readFileAndWords(filePath);
		instance.printWords(distinctWords);
	}

	private Map<String, Integer> readFileAndWords(String filePath) {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
			return readLineAndCountWords(reader);
		} catch (IOException e) {
			System.out.println("IOException while reading file - " + e);
		}
		return Collections.emptyMap();
	}

	private Map<String, Integer> readLineAndCountWords(BufferedReader reader) throws IOException {
		Map<String, Integer> wordCount = new HashMap<>();
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] words = line.split("\\W+");
			countWords(words, wordCount);
		}
		return wordCount;
	}

	private void countWords(String[] words, Map<String, Integer> wordCount) {
		for (String word : words) {
			String lowerCaseKey = word.toLowerCase();
			Integer newValue = wordCount.computeIfPresent(lowerCaseKey, (key, value) -> value + 1);
			if (newValue == null) {
				wordCount.put(lowerCaseKey, 1);
			}
		}
	}

	private void printWords(Map<String, Integer> wordCount) {
		wordCount.forEach((word, count) -> System.out.println("Word " + word + " occurs " + count + " times"));
	}
}
