package com.bootcamp.archiver;

public class CommandLineReader {

	public static void main(String[] args) {
		System.out.println("Command line arguments:");
		for (String arg : args) {
			System.out.println(arg);
		}
	}
}
