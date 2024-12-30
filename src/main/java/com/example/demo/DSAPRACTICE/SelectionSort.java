package com.example.demo.DSAPRACTICE;

public class SelectionSort {
    public static void sort(int arr[]){
        for(int i =0;i<arr.length-1;i++){
            int small  = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[small]){
                    small = j;
                }
                
            }
            int temp = arr[i];
                arr[i] = arr[small];
                arr[small ]= temp;
            

        }
    }
        public static void main(String args[]){
            int arr[] = {5,6,1,3,8,9,3,4};
            sort(arr);
            for(int i = 0 ;i<arr.length;i++){
                System.out.println(arr[i]);
            }

        }
    
    
}

