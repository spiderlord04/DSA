package com.example.demo.ArrayList;
import java.util.ArrayList;
import java.util.Collections;
public class ArrayList1 {

    public static void swap(ArrayList<Integer> list,int idx1,int idx2){
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //add - O(1)
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(245);
        System.out.println(list);
        //remove - O(n)
        list.remove(2);
        System.out.println(list);
        //get - O(1)
        System.out.println(list.get(1));
        //set at particular index
        //set - O(n)
        list.set(0, 25);
        System.out.println(list.contains(25));
        //add - O(n)
        list.add(2,100);
        System.out.println(list);

        //size 
        System.out.println(list.size());
        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //Q1 -- Reverse
        for(int i = list.size()-1;i>= 0 ;i--){
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");

        // Q2 -- MAX VALUE
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<list.size();i++){
            max = Math.max(max, list.get(i));
        }
        System.out.println(max);

        //Q3 -- swap 2 numbers
        int idx1 = 1,idx2 =3;
        System.out.println(list);
        swap(list, idx1, idx2);
        System.out.println(list);
        
        // Q4 -- sorting using Collections class
        Collections.sort(list);
        System.out.println(list);
        
    }

}
