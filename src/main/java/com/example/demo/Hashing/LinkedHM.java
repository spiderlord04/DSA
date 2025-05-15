package com.example.demo.Hashing;
import java.util.LinkedHashMap;

public class LinkedHM {
    //keys are Insertion Ordered...i.e the order of keys is maintained according to insetion ordere..

    public static void main(String[] args) {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
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
