package com.example.demo.GreedyAlgorithms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionNotSorted {
    public static void main(String[] args) {
        int start[] = {0,1,3,5,5,8};
        int end[] = {6,2,4,7,9,9};
        //sorting keliye ek 2d array 
        int activites[][] = new int[start.length][3];

        /*
         * 
         * activites = [
    [0, 0, 6], // index 0, start 0, end 6
    [1, 1, 2], // index 1, start 1, end 2
    [2, 3, 4], // index 2, start 3, end 4
    [3, 5, 7], // index 3, start 5, end 7
    [4, 5, 9], // index 4, start 5, end 9
    [5, 8, 9]  // index 5, start 8, end 9
]

         */
        for(int i = 0;i<start.length;i++){
            activites[i][0] = i; //index of 2d array's rows
            activites[i][1] = start[i];//store start values
            activites[i][2] = end[i]; //store end values;
        }
        //now actual sorting using comparator
        Arrays.sort(activites,Comparator.comparingDouble(o -> o[2]));
        /*
         * after sorting  by the end times (ascending order):
         * activites = [
    [1, 1, 2], // index 1, start 1, end 2
    [2, 3, 4], // index 2, start 3, end 4
    [0, 0, 6], // index 0, start 0, end 6
    [3, 5, 7], // index 3, start 5, end 7
    [4, 5, 9], // index 4, start 5, end 9
    [5, 8, 9]  // index 5, start 8, end 9
]

         */
        int maxAct = 0; //count of max activites performed.
        //completed activites store karne k liye arraylist

        ArrayList<Integer> ans = new ArrayList<>();
        //step add the first activity as wo kam time mein complete hoga aur hum doserey activites complete kar sakte hai
        ans.add(activites[0][0]); 
        maxAct = 1;
        int lastEnd = activites[0][2]; // as the first activity is now completed 
        for(int i = 1; i<end.length;i++){
            //condition : next job should start from the last ended of after that but not before that so we take another variable lastEnd to tack teh last end valeu;
            if(activites[i][1] >= lastEnd){
                //then we add to list and update the maxAct;
                ans.add(activites[i][0]);
                lastEnd = activites[i][2];
                maxAct++;
            }
        }
        System.out.println("Max no activites performed is ;  "+maxAct);
        for(int i = 0 ; i< ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
    }
    
}
