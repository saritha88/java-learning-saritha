package com.linkedlist;

public class StackLinkedList {

	SinglyLinkedList list;

	public StackLinkedList() {
		super();
		list = new SinglyLinkedList();
	}

	public void push(int val) {
		list.addFirst(val);
	}

	public SinglyLinkedList pop() {
		list.deleteFirst();
		return list;
	}

	private int top() {
		return list.head.getData();
	}

	public int getData(int i) {
		int data = 0;
		data = list.getData(i);
		return data;
	}

	public static void main(String[] args) {

		StackLinkedList st = new StackLinkedList();
		st.push(1);
		st.push(2);
		st.push(3);
		st.pop();
		int data = st.top();
		System.out.println("top data=" + data);
	}

}
