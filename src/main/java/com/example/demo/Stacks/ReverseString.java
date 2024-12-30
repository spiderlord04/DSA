package com.example.demo.Stacks;
import java.util.Stack;

public class ReverseString {
   
     public static String reverseString(String str){
        Stack<Character> strStack = new Stack<>();
        StringBuilder s = new StringBuilder();
       for(int i = 0;i<str.length();i++){
        char c = str.charAt(i);
        strStack.push(c);
       }
       while(!strStack.isEmpty()){
        s.append(strStack.pop());
       }
        return s.toString();
    }
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println(s);
       String str = "edcba";
      str =  reverseString(str);
      System.out.println(str);

    }
}
