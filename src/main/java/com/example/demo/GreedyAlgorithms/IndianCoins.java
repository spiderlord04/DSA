package com.example.demo.GreedyAlgorithms;

import java.util.*;
//We are given an infinte supply of denominations[1,2,5,10,20,50,100,500,2000];.Find min no. of coins/notes to make change for a value V.
// v= 121
// ans = 3(100 +20 +10); 
//v = 590;
//ans=4(500+50+20+20);

public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[]={1,2,5,10,20,50,100,500,2000};

        //sorting in decreasing order;
        Arrays.sort(coins,Comparator.reverseOrder());

        int amount = 1059;
        int countOfCoins = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<coins.length;i++){
            //coin ka value<= amount;
            if(coins[i] <= amount){
                //for how many times the sigle note/coin has to be selected we use while loop. 
                while(coins[i] <= amount){
                    countOfCoins++;
                    amount -= coins[i];
                    ans.add(coins[i]);
                }
            }
        }
        System.out.println("Total (min) coins used =" +countOfCoins);
        for(int i  = 0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
