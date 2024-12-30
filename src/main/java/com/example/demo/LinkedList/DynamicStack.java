package com.example.demo.LinkedList;

import java.util.ArrayList;


public class DynamicStack {
    private ArrayList<Integer> stackList = new ArrayList<>(); // Dynamic list to store stack elements
    // Constructor to initialize the stack
    // public DynamicStack() {
        // stackList = new ArrayList<>();
    // }
    // Push an element onto the stack
    public void push(int value) {
        stackList.add(value); // Add element to the end of the list
    }
    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow: Cannot pop from an empty stack.");
            return -1; // Return -1 to indicate an error
        }
        return stackList.remove(stackList.size() - 1); // Remove and return the last element
    }
    // Peek at the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty: Cannot peek.");
            return -1; // Return -1 to indicate an error
        }
        return stackList.get(stackList.size() - 1); // Return the last element
    }
    // Check if the stack is empty
    public boolean isEmpty() {
        return stackList.isEmpty();
    }
    // Get the current size of the stack
    public int size() {
        return stackList.size();
    }
		public void display() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return;
        }
        System.out.println("Stack elements (top to bottom):");
        for (int i = stackList.size() - 1; i >= 0; i--) {
            System.out.print(stackList.get(i) + " ");
        }
        System.out.println();
    }
    // Test the Dynamic Stack
    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack();
        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Size after pushes: " + stack.size()); // Output: 3
        // Peek at the top element
        System.out.println("Top element: " + stack.peek()); // Output: 30
        // Pop elements
        System.out.println("Popped: " + stack.pop()); // Output: 30
        System.out.println("Popped: " + stack.pop()); // Output: 20
        System.out.println("Size after pops: " + stack.size()); // Output: 1
        // Push more elements
        // for (int i = 1; i <= 5; i++) {
        //     stack.push(i * 10);
        // }
        System.out.println("Size after adding more elements: " + stack.size()); // Output: 6
        System.out.println("Top element: " + stack.peek()); // Output: 50
    }
}