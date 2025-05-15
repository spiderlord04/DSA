package com.example.demo.Hashing;
import java.util.HashSet;

public class UnionAndIntesectionOfTwoArraysHS {

    public static void main(String[] args) {
        int arr[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        HashSet<Integer> set = new HashSet<>();
        //union
        for(int i = 0;i<arr.length;i++){
            set.add(arr[i]);
        }
        for(int i = 0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        System.out.println("Union :  "+set.size());
        set.clear();
        for(int i = 0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int count = 0;
        for(int i : arr2){
            if(set.contains(i)){
                count++;
                set.remove(i);
            }
        }
        System.out.println("Intersection: " + count);
    }

}