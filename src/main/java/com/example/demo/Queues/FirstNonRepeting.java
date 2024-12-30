package com.example.demo.Queues;

import java.util.*;
//Q : First Non-Repeating Letter in a Stream of characters.
//most of the time when we see steam of charactes we use quess.

public class FirstNonRepeting {
    public static void printNonRepeating(String s){
        int[] freq  = new int[26]; //for all count of all albphabets .
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i< s.length();i++){
            char ch = s.charAt(i);
            q.add(ch);
            freq[ch -'a']++;
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if(q.isEmpty()){
System.out.print(-1 + " ");        
            }else{
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();

    }
    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
        
    }
}
