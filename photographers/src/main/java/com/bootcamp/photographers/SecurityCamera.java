package com.bootcamp.photographers;

public class SecurityCamera implements Photographer {

	@Override
	public void prepareScene() {
		System.out.println("Let the object cover atleast 10% of the screen.");
	}

	@Override
	public String takePhotograph() {
		return "Object caught.";
	}

}
