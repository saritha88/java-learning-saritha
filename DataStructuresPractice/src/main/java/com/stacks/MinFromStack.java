package com.stacks;

/**
 * @author sarithab on 03/04/20
 */
public class MinFromStack {
    StackNode root;
    StackNode min;

    static class StackNode {
        int data;
        StackNode next;

        public StackNode(int data) {
            this.data = data;
        }
    }

    boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    int push(int x) {
        StackNode newNode = new StackNode(x);
        if (root == null) {
            root = newNode;
            min = newNode;
            return newNode.data;
        } else {
            StackNode temp = root;
            root = newNode;
            newNode.next = temp;
            if (min.data > newNode.data) {
                min.data = newNode.data;
            }
            return newNode.data;
        }
    }

    int min() {
        return min.data;
    }

    int pop() {
        int data = Integer.MIN_VALUE;
        if (root == null) {
            System.out.println("Stack is empty");
        } else {
            data = root.data;
            root = root.next;
            System.out.println("Popped " + data);
        }
        return data;
    }

    public int peek() {
        if (root == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        } else {
            return root.data;
        }
    }

    public static void main(String[] args) {
     MinFromStack sll = new MinFromStack();
        sll.push(11);
        sll.push(20);
        sll.push(30);
        sll.push(20);
        System.out.println("Minimum value "+sll.min());
    }

}
