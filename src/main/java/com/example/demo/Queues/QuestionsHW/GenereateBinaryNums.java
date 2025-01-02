package com.example.demo.Queues.QuestionsHW;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;


//Question 1 :
// Generate Binary Numbers
// Given a number N. The task is to generate and print all binary numbers with decimal values from
// 1 to N.
// Sample Input 1 : N =2
// Sample Output 1 : 1 10
// Sample Input 2 : 5.
// Sample Output 2 : 1 10 11 100 101


public class GenereateBinaryNums {
    public static void main(String args[]){
        Queue<String> q = new LinkedList<>();
        int n = new Scanner(System.in).nextInt();
        q.add("1");
        while(n > 0){
            String s1  = q.poll();
            System.out.print(s1 + " ");
            // String s2 = s1;
            q.add(s1+"0");
            q.add(s1+"1");
            n--;

        }
    }
}
