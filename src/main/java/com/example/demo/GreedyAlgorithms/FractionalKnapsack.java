package com.example.demo.GreedyAlgorithms;
import java.util.*;
public class FractionalKnapsack {
    public static void main(String[] args) {
        int value[] = {60,100,120};
        int weight[] = {10,20,30};
        int w = 50;

        //ratio ko claulate aur sorting karn hai tho sorting karne ke liye 2d arr
        double ratio[][] = new double[value.length][2]; // ek index ke leye aur ek ratio k liye

        for(int i = 0;i<value.length;i++){
            ratio[i][0] = i; //index;
            ratio[i][1] = value[i]/(double)weight[i]; //ratio formula = val/wight;
        }

        //ascending order sort
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        //ab wo purey ascending mein sort hoke hai tho abb hum llop ko reverse karthei hai as hume ratio descending order mein chahiye

        int capacity = w; //capacity ko track karne ke liye
        int finalVal = 0;
        for(int i = ratio.length-1;i>=0;i-- ){
            //yaha pe konse index ka sabse high ratio hai us index ko nikal they hai ..(after sorting)..
            int idx =(int) ratio[i][0]; 
            if(capacity >= weight[idx]){
                capacity -= weight[idx];
                finalVal += value[idx];
            }else{
                //include fractional items
                finalVal += (capacity * ratio[i][1]);
                capacity = 0;
            }
        }
        System.out.println(finalVal);


    }
}
