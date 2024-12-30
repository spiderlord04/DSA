package com.example.demo.Queues;
import java.util.*;
//Q :  interleave 2 halves of a Queue even lenght
// 12345 678910
//16273849510

public class Interleave {
    public static void interleave(Queue<Integer> q){
        Queue<Integer> firsthalf = new LinkedList<>();
        int size = q.size();
        for(int i = 0 ;i<size/2;i++){
            firsthalf.add(q.remove());
        }
        while (!firsthalf.isEmpty()) {

            q.add(firsthalf.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(); 
        //or
        //Queue<Integer> q = new ArrayDeque<>(); 

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);


        System.out.println(q);
        interleave(q);
        System.out.println(q);
    }
}
