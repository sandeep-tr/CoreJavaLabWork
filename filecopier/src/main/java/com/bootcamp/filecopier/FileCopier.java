package com.bootcamp.filecopier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopier {

	private static final String FILE_PREFIX = "src/main/resources/";
	private Scanner scanner;

	public FileCopier() {
		this.scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		FileCopier instance = new FileCopier();

		FileReader sourceReader = instance.promptSourceFile();
		FileWriter destinationWriter = instance.promptDestinationFile();
		instance.scanner.close();
		try {
			instance.copyFileContent(sourceReader, destinationWriter);
			System.out.println("File contents copied successfully");
		} catch (IOException e) {
			System.err.println("IOException while copying contents - " + e);
		}		
	}

	private FileReader promptSourceFile() {
		while (true) {
			System.out.println("Enter source file name");
			String fileName = scanner.nextLine();
			try {
				FileReader fileReader = new FileReader(new File(FILE_PREFIX + fileName));
				return fileReader;
			} catch (IOException e) {
				System.err.println("IOException while opening source file - " + e);
			}
		}
	}

	private FileWriter promptDestinationFile() {
		while (true) {
			System.out.println("Enter destination file name");
			String fileName = scanner.nextLine();
			try {
				FileWriter fileWriter = new FileWriter(new File(FILE_PREFIX + fileName));
				return fileWriter;
			} catch (IOException e) {
				System.err.println("IOException while opening destination file - " + e);
			}
		}
	}

	private void copyFileContent(FileReader reader, FileWriter writer) throws IOException {
		try (BufferedReader buffReader = new BufferedReader(reader);
				BufferedWriter buffWriter = new BufferedWriter(writer)) {

			String line = null;
			while ((line = buffReader.readLine()) != null) {
				buffWriter.write(line);
				buffWriter.newLine();
			}
		}
	}

}
