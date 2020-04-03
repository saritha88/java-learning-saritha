package com.stacks;

/**
 * @author sarithab on 03/04/20
 */
public class StackTest {
    int top;
    int max = 100;
    int arr[] = new int[max];

    StackTest() {
        top = -1;
    }

    boolean isEmpty() {
        return (top > 0);
    }

    int push(int x) {
        if (top < max) {
            arr[++top] =x;
            System.out.println("Pushed to stack "+arr[top]);
            return arr[top];
        } else {
            System.out.println("Stack overflow");
            return 0;
        }
    }


    int pop() {
        if (top < 0) {
            System.out.println("Stack is empty");
            return 0;
        } else {
             int   x = arr[top--];
            return x;
        }
    }

    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(3);
        stackTest.push(4);
        System.out.println("Poped fro  stack "+stackTest.pop());
        System.out.println("Poped fro  stack "+stackTest.pop());

    }
}
