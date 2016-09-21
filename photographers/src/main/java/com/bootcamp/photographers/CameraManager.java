package com.bootcamp.photographers;

public class CameraManager {

	public static void main(String[] args) {
		Photographer[] photographers = { new SecurityCamera(), new SpySatellite(), new TrafficCamera() };

		for (Photographer photographer : photographers) {
			photographer.prepareScene();
			System.out.println(photographer.takePhotograph());
		}
	}
}
