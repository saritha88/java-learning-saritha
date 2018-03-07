package com.learning;

public class Stack {

	private int size = 0;
	private int arr[];
	private int index = 0;

	public Stack(int size) {
		super();
		this.size = size;
		this.arr = new int[size];
	}

	public void push(int element) {
		if (isFull()) {
			throw new StackOverflowError("stack is full");
		}

		arr[index] = element;
		index++;

	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		}
		return arr[--index];

	}

	public Boolean isFull() {
		if (index == size) {
			return true;
		}
		return false;
	}

	public Boolean isEmpty() {
		if (index == 0)
			return true;
		return false;

	}

	public int size() {
		return index;
	}
}
