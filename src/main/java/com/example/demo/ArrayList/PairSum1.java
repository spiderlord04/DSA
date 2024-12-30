package com.example.demo.ArrayList;
import java.util.*;
public class PairSum1 {
    //Q::-- Find if any pair in a sorted array list has a target sum...
    public static boolean pairSum1(ArrayList<Integer> list,int target){
        //two pointers
        int lp = 0;
        int rp = list.size()-1;
        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }else if(list.get(lp)+list.get(rp) < target){
                lp++;
            }
            else{
                rp--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;
        System.out.println(pairSum1(list, target));

    }
}
