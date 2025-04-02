package com.example.demo.Heaps_and_PriorityQ;
// Q: given Are n ropes of differrnt lengths the task is to connect into one rope with minimun cost such that the cost to connect the 2 ropes is eqal to the sum of their lengths
//ropes {4,3,2,6}
// ans = 29

import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        
        int ropes[] = {4,3,2,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<ropes.length;i++){
            pq.add(ropes[i]);
    }
    int cost = 0;
    //until my pq has more than one elemetn 
    while(pq.size() >1){
        int a = pq.remove();//first ele
        int b = pq.remove();//second ele
        cost+= a+b;//sum of 2 ropes
        pq.add(a+b);
    }
    System.out.println(cost);
}
}
