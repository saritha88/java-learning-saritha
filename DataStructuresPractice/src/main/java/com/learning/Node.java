package com.learning;

public class Node {

	private int data;
	private Node next;

	public Node() {
		super();
		this.data = 0;
		this.next = null;
	}

	public Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
