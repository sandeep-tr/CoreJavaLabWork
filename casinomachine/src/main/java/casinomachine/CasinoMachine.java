package casinomachine;

import java.util.concurrent.ThreadLocalRandom;

public class CasinoMachine {

	enum States {
		BAR, MEDAL, COIN, TRIPLEBAR, CHERRY
	}

	public static void main(String[] args) {

		int[] spunWheels = spin(3);
		printWheelPositions(spunWheels);
	}

	private static int[] spin(int numberOfWheels) {
		int[] wheels = new int[numberOfWheels];
		for (int i = 0; i < numberOfWheels; i++) {
			wheels[i] = ThreadLocalRandom.current().nextInt(5);
		}
		return wheels;
	}

	private static void printWheelPositions(int[] wheels) {
		for (int wheel : wheels) {
			System.out.print(States.values()[wheel] + " : ");
		}
	}

}
