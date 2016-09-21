package com.bootcamp.photographers;

public class SpySatellite implements Photographer {

	@Override
	public void prepareScene() {
		System.out.println("Waiting for the sky to be clear.");
	}

	@Override
	public String takePhotograph() {
		return "Caught...";
	}
}
