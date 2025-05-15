package com.example.demo.Hashing;
import java.util.HashMap;

public class ItineraryTickets {
    public static String findStartPoint( HashMap<String,String> tickets){
        //this func to find the start point
        //to make that happen then we should revse it (i.e -> to - from)..
        HashMap<String,String> revMap = new HashMap<>();
        for(String key: tickets.keySet()){
            //to - from s
            revMap.put(tickets.get(key),key);
        }
        //so now find the point which has only start but no end ..
        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key; //starting point..
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai","Benguluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");
        String st = findStartPoint(tickets);
        System.out.print(st);
        for(String key : tickets.keySet()){
            System.out.print("--> "+ tickets.get(st));
            st = tickets.get(st);
        }

    }
}
