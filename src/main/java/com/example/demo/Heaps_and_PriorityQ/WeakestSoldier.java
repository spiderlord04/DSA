package com.example.demo.Heaps_and_PriorityQ;

import java.util.Arrays;
import java.util.PriorityQueue;

//#1337

// You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

// A row i is weaker than a row j if one of the following is true:

// The number of soldiers in row i is less than the number of soldiers in row j.
// Both rows have the same number of soldiers and i < j.
// Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

// Input: mat = 
// [[1,0,0,0],
//  [1,1,1,1],
//  [1,0,0,0],
//  [1,0,0,0]], 
// k = 2
// Output: [0,2]
// Explanation: 
// The number of soldiers in each row is: 
// - Row 0: 1 
// - Row 1: 4 
// - Row 2: 1 
// - Row 3: 1 
// The rows ordered from weakest to strongest are [0,2,3,1].


public class WeakestSoldier {
    static class Row implements Comparable<Row>{
        int soldier;
        int idx;
        public Row(int soldier,int idx){
            this.soldier = soldier;
            this.idx = idx;
        }
        //to implemtn the menntod of comparable 
        @Override
        public int compareTo(Row r2){
            //redefine the compareTO logic as comapre to return 0 if both are same
            if(this.soldier == r2.soldier){
                return this.idx -r2.idx;//return the smallest idx..As the largest index soldier is Strontest..
            }else{
                return this.soldier - r2.soldier;
            }
        }
    }
    public static void main(String[] args) {
        int mat[][] = {{1,0,0,0},
        {1,1,1,1},
        {1,0,0,0},
        {1,0,0,0}};
        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i = 0;i<mat.length;i++){
            int count = 0;
            for(int j = 0;j<mat[i].length;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            pq.add(new Row(count,i));
        }
        int ans[] = new int[k];
        for(int i = 0;i<k;i++){
            int soldierIdx = pq.remove().idx;
            ans[i] = soldierIdx;
        }
       System.out.println(Arrays.toString(ans));
    }
}
