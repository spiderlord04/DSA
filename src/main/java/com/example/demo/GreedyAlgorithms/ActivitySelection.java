package com.example.demo.GreedyAlgorithms;

import java.util.ArrayList;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        int maxAct = 0; //count of max activites performed.
        //completed activites store karne k liye arraylist

        ArrayList<Integer> ans = new ArrayList<>();
        //step add the first activity as wo kam time mein complete hoga aur hum doserey activites complete kar sakte hai
        ans.add(0); 
        maxAct = 1;
        int lastEnd = end[0]; // as the first activity is now completed 
        for(int i = 1; i<end.length;i++){
            //condition : next job should start from the last ended of after that but not before that so we take another variable lastEnd to tack teh last end valeu;
            if(start[i] >= lastEnd){
                //then we add to list and update the maxAct;
                ans.add(i);
                lastEnd = end[i];
                maxAct++;
            }
        }
        System.out.println("Max no activites performed is ;  "+maxAct);
        for(int i = 0 ; i< ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
    }
}


