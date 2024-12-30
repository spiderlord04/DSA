package com.example.demo.Queues;
import java.util.*;
public class QWIthJFC {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(); 
        //or
        //Queue<Integer> q = new ArrayDeque<>(); 

        q.add(10);
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        System.out.println(q);

    //NOTE
    /*
     * Time Com
     * Add - O(1)
     * remove - O(1);
     * peek - O(1)
     */

    }
}
