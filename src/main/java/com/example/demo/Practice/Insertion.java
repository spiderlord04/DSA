package com.example.demo.Practice;

public class Insertion {
    public static void main(String[] args) {
        int arr[] = {3,4,5,8,1,9,0};
        for(int i = 1;i<arr.length;i++){
            int curr   = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] >curr){
                j--;
                arr[j+1] = arr[j];
            }
            arr[j+1] = curr;
        }
        for(int i : arr){
            System.out.print(i +" ");
        }
    }

}
