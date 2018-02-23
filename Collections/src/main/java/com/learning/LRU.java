package com.learning;

import java.util.LinkedList;
import java.util.List;

public class LRU {

	private LinkedList<Integer> list;
	int capacity;

	public LRU(int capacity) {
		super();
		this.capacity = capacity;
		this.list = new LinkedList<>();
	}

	private void addElement(int i) {
		if (list.size() < this.capacity) {
			if (!list.contains(i)) {

				list.addFirst(i);
			} else {
				list.removeLastOccurrence(i);
				list.addFirst(i);
			}

		} else {

			if (!list.contains(i)) {
				list.removeLast();

				list.addFirst(i);
			} else {

				list.removeLastOccurrence(i);
				list.addFirst(i);
			}

		}
	}

	private LinkedList<Integer> getElements() {
		return this.list;

	}

	public static void main(String[] args) {

		LRU cache = new LRU(3);
		cache.addElement(1);
		cache.addElement(2);
		cache.addElement(2);
		cache.addElement(3);
		cache.addElement(4);
		cache.addElement(2);
		List<Integer> result = cache.getElements();
		System.out.println(result);

	}

}
