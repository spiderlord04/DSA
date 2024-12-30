package com.example.demo.Queues;

import java.util.Stack;

//implement Queue using 2 Stacks
 
public class QUsingStacks {
    static  Stack<Integer> s1 = new Stack<>();
     static Stack<Integer> s2 = new Stack<>();

     public boolean isEmpty(){
        return s1.isEmpty();
     }
     public void add(int data){
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
            
        }
        s1.push(data);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

     }
     public int remove(){
    if(isEmpty()){
        return -1;
    }
    return s1.pop();
     }
     public void display(){
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        for(int i = s1.size()-1 ; i>=0;i--){
            System.out.print(s1.get(i)+" ");
        }
     }

     public static void main(String[] args) {
        QUsingStacks q = new QUsingStacks();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.display();
     }
}
