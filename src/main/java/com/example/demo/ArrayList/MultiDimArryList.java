package com.example.demo.ArrayList;

import java.util.ArrayList;
public class MultiDimArryList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> main = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        // values
        for(int i = 1;i<= 5;i++){
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }
        main.add(list1);
        main.add(list2);
        main.add(list3);
        System.out.println(main);

        for(int i = 0;i<main.size();i++){
            ArrayList<Integer> curr = main.get(i);
            for(int j = 0;j<curr.size();j++){
                System.out.print(curr.get(j));
            }
            System.out.println();
        }

    }
}
