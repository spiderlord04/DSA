package com.example.demo.Hashing;
import java.util.HashMap;
public class MajorityElement {
    // Q : elements that appear more than n/3 times .... where n is size of arrr...
    public static void main(String[] args) {
        int arr[] = { 1,3,2,5,1,3,1,5,1};
        int n = arr.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        // System.out.println(map);
        for(Integer i: map.keySet()){
            if(map.get(i)>n/3){
                System.out.println(i);
            }
        }
    }
}
