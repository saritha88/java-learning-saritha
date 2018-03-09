package com.learning;

public class LinkedListExample {

	Node head;
	Node tail;
	int size = 0;

	public LinkedListExample() {
		super();
		this.head = null;
		this.tail = null;
	}

	public int getSize() {
		return size;
	}

	public void addFirst(int val) {
		Node newnode = new Node(val, null);
		if (head == null) {
			head = newnode;
			tail = head;
		} else {
			newnode.setNext(head);
			head = newnode;
		}
		size++;
	}

	public void add(int val) {
		Node newnode = new Node(val, null);
		size++;
		if (head == null) {
			head = newnode;
			tail = head;
		} else {

			tail.setNext(newnode);
			tail = newnode;
		}

	}

	public int getData(int i) {
		Node temp = head;
		int data = 0;
		for (int j = 0; j < size; j++) {

			if (i == j) {
				data = temp.getData();

			}
			temp = temp.getNext();
		}

		return data;
	}

	public void addAtPos(int val, int pos) {
		Node newnode = new Node(val, null);
		Node ptr = head;
		pos = pos - 1;
		for (int i = 1; i < size; i++) {
			if (i == pos) {
				Node temp = ptr.getNext();
				ptr.setNext(newnode);
				newnode.setNext(temp);
				break;
			}

			ptr = ptr.getNext();
		}

		size++;
	}

	public void deleteAtPos(int pos) {

		Node ptr = head;

		if (pos == 0) {
			head = head.getNext();
		} else {
			pos = pos - 1;
			for (int i = 0; i < size; i++) {

				if (i == pos) {
					ptr.setNext(ptr.getNext().getNext());

					break;
				}

				ptr = ptr.getNext();
			}
		}

		size--;
	}

	public void deleteFirst() {
		head = head.getNext();
		size--;
	}

	public void deleteLast() {
		Node ptr = head;

		for (int i = 0; i < size; i++) {
			int pos = size - 1;
			if (i == pos) {
				ptr.setNext(null);
				
			}
			ptr = ptr.getNext();
		}

		size--;

	}

	public static void main(String[] args) {

		LinkedListExample list = new LinkedListExample();

		list.addFirst(1);
		list.add(10);
		list.add(13);
		list.addAtPos(122, 2);
		System.out.println("before deleting");

		for (int i = 0; i < list.size; i++) {
			System.out.println("index=" + i + "  value=" + list.getData(i));
		}
		list.deleteLast();
		System.out.println("after deleting");

		for (int i = 0; i < list.size; i++) {
			System.out.println("index=" + i + "  value=" + list.getData(i));
		}

	}

}