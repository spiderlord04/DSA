package com.example.demo.Stacks;
import java.util.Stack;
public class ReverseStack {

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

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        insertAtBottom(s, top);

    }
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println(s);
        reverseStack(s);
        System.out.println(s);
      

    }
    
}