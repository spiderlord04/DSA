package com.example.demo.GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

//You are given n paris of numbers. In every pair, the first number is always smaller than the second number . A pair(c,d) can come after pair(a,b) if b<c.
//find the longest chain which can be formed from a givem set of pairs.
public class MaxLengthChainofPairs {
    public static void main(String[] args) {
        int pairs[][] ={{5,24},{39,60},{5,28},{27,40},{50,90}};

        //sorting on based on 2nd number...
        Arrays.sort(pairs,Comparator.comparingDouble(o -> o[1]));

        //1st activity or pair select karna hai hamesa..
        int chainLen = 1;
        //last selected pair end  (selected pair ka end)
        int chainEnd = pairs[0][1];//cahin end;
        for(int i = 1; i<pairs.length;i++){
            //start>Lastend
            if(pairs[i][0] > chainEnd){
                chainLen++;
                chainEnd = pairs[i][1];//update end;
            }
        }
        System.out.println("Max length of chain is: " + chainLen);
    }
}
