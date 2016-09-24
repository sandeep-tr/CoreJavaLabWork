package com.bootcamp.listlike;

import java.util.Iterator;

public class SequenceIteratorTest {

	public static void main(String[] args) {
		Sequence s = new Sequence();
		s.add("Hello");
		s.add("there");
		s.add("done");
		Iterator<String> i1 = s.iterator();
		Iterator<String> i2 = s.iterator();
		assert i1.hasNext();
		assert i1.next().equals("Hello");
		assert i1.hasNext();
		assert i1.next().equals("there");
		assert i2.hasNext();
		assert i2.next().equals("Hello");
		assert i1.hasNext();
		assert i1.next().equals("done");
		assert i1.hasNext() == false;
		assert i2.next().equals("there");
		assert i2.next().equals("done");
		assert i2.hasNext() == false;

		// -- for each iterable
		for (String str : s) {
			System.out.println(str);
		}
	}
}
