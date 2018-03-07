package com.learning;

public class StackArray {
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		// stack.push(6);
		System.out.println("before poping" + stack.size());
		stack.pop();
		stack.pop();

		System.out.println("size after poping" + stack.size());
	}

}
