package com.example.demo.Hashing;
import java.util.HashMap;

public class SubArrEqtK {
    public static void main(String args[]){
        int arr[] = {10,2,-2,-20,10};
        int k = -10;
        HashMap<Integer,Integer>map = new HashMap<>();
        //      sum    , count 
        //formula : sum(j)-k = sum(i)..
        int sum = 0;
        int count = 0;

        //put(0,1) // as these is condition like the sum = k and only one element then the ans is 1 and sum according to formula is 0..
        map.put(0,1);
        for(int i : arr){
            sum+= i;
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum, 0)+1);

        }
        System.out.println(count);
    }
}
