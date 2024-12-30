package com.example.demo.Stacks;
import java.util.Stack;

public class InsAtBottom {
    public static void insertAtBottom(Stack<Integer> stack,int data){
        //recursion
        //base case 
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }

       int top =  stack.pop();
       insertAtBottom(stack, data);
       stack.push(top);

    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s);
        insertAtBottom(s,40);
        System.out.println(s);
    }
}
