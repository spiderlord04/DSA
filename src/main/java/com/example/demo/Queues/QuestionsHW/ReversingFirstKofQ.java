package com.example.demo.Queues.QuestionsHW;
import java.util.*;

/*
 * Question 4 :
Reversing the rst K elements of a Queue
We have an integer k and a queue of integers, we need to reverse the order of the rst k
elements of the queue, leaving the other elements in the same relative order.
Sample Input 1 : Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100] ,k=5
Sample Output 1 : Q = [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]

 */
public class ReversingFirstKofQ {
    public static void reverseKEle(Queue<Integer> q,int k){
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<k;i++){
            s.push(q.poll());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
            
        }
        for(int i = 0;i<q.size()-k;i++){
            q.add(q.poll());
        }




    //     Queue<Integer> t = new LinkedList<>();
    //    while(!q.isEmpty()){
    //     t.add(q.remove());
    //    }
    //   while (!s.isEmpty()) {
    //     q.add(s.pop());
    //   }
    //   while (!t.isEmpty()) {
    //     q.add(t.remove());
    //   }
    //if i use this Space Com is O(n);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        for(int i : arr){
            q.add(i);
        }
        
        System.out.println(q);
        reverseKEle(q,5);
        System.out.print(q);

        // TC : O(n);
        // SC : O(1);
    }
}
