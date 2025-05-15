package com.example.demo.Hashing;
import java.util.*;

public class IterationOnHash {

    public static void main(String args[]){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India", 150);
        map.put("chiana",160);
        map.put("madrid",699);
        //using Set
        // HashMap will have a fucntion " keySet()"--> return a set of keys
        Set<String> keys = map.keySet();
        System.out.println(keys);
    }
}