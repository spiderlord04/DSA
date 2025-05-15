package com.example.demo.Hashing;
import java.util.TreeMap;

public class TreeMapp {
    public static void main(String[] args) {
        TreeMap<String,Integer> map = new TreeMap<>();
        map.put("India", 120);
        map.put("America", 130);
        map.put("Japan", 50);
        System.out.println(map.keySet());
        System.out.println("Keys: " + map.keySet());
        System.out.println("Value for India: " + map.get("India"));
        map.remove("Japan");
        System.out.println("After removing Japan: " + map.keySet());
    }
}
