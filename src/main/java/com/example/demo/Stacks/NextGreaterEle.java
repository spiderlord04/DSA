package com.example.demo.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterEle {
    public static void main(String args[]){
        int arr[] = {6,8,0,1,3};
        int greaterele[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1;i>=0;i--){
            //while chekc
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();            
            }
    
            //step -2 check elif
            if(s.isEmpty()){
                greaterele[i] = -1;
            }else{
                greaterele[i] = arr[s.peek()];
            }

            
            //push
            s.push(i);
        }

        System.out.print(Arrays.toString(greaterele));

    }
}
