package com.example.demo.GreedyAlgorithms;
import java.util.Arrays;


//Min Absolute Difference Pairs
//Given 2 arrays A and B of equal length n . Pair each element of array A to an element in array B, such that sum S of absoulte differences of all the pairs is minimum.

// A = [1,2,3]

//b = [2,1,3]
//ans = 0

public class MinAbsoluteDifferencePair {
    public static void main(String[] args) {
        
        int a[] = {1,2,3};
        int b[] = {2,1,3};
        //sort both the arrays ascending as now the minmun of both the arrays are arranged the min of a array and b array difference will give.
        
        Arrays.sort(a);
        Arrays.sort(b);

        //now find sum of absolute mindiff of pairs
        int minDiff = 0;
        for(int i = 0;i<a.length;i++){
            minDiff+= Math.abs(a[i] - b[i]);
        }
        System.out.printf("The min absolute difference of pairs : %s \n",minDiff);

        //O(nlogn)
    }
    
}
