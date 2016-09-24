package com.bootcamp.listlike;

import java.util.Iterator;

public class Sequence implements Iterable<String> {

	private static final int ARR_SIZE = 10;
	private int size;
	private String[] collection;

	public Sequence() {
		this.collection = new String[ARR_SIZE];
	}

	public void add(String string) {
		if (size >= ARR_SIZE) {
			throw new ArrayStoreException("Array reached max size. Cannot store anymore");
		}
		collection[size++] = string;
	}

	public Object get(int index) {
		return collection[index];
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<String> iterator() {
		return new SequenceIterator(size, collection);
	}

	private class SequenceIterator implements Iterator<String> {

		private int progress = 0;
		private int currentSize;
		private String[] collection;

		public SequenceIterator(int currentSize, String[] collection) {
			this.currentSize = currentSize;
			this.collection = collection;
		}

		@Override
		public boolean hasNext() {
			return (progress < currentSize);
		}

		@Override
		public String next() {
			return collection[progress++];
		}

	}
}
