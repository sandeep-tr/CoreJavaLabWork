package com.bootcamp.photographers;

public class TrafficCamera implements Photographer {

	@Override
	public void prepareScene() {
		System.out.println("Waiting for the number plate to show up.");
	}

	@Override
	public String takePhotograph() {
		return "Whoo.. Time to pay some fine.";
	}
}
