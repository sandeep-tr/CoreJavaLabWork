package com.bootcamp.listlike;

public class SequenceTest {

	public static void main(String[] args) {
		Sequence s = new Sequence();
		assert s.size() == 0;
		s.add("Hello");
		s.add("there");
		assert s.size() == 2;
		assert s.get(0).equals("Hello");
		assert s.get(1).equals("there");
		s.add("done");
		assert s.size() == 3;
		assert s.get(0).equals("Hello");
		assert s.get(1).equals("there");
		assert s.get(2).equals("done");
	}
}
