package com.example.demo.Queues.QuestionsHW;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxofAllsubarrs {

//     Question 5 :
// Maximum of all subarrays of size k
// We have an array arr[] of size N and an integer K. Find the maximum for each and every
// contiguous subarray of size K.
// Sample Input 1 : N=9, K=3 arr= 1 2 3 1 4 5 2 3 6
// Sample Output 1 : 3 3 4 5 5 5 6

    public static int[] findMaxInSubarrays(int arr[],int k){
        //Dequ
        Deque<Integer> deque = new ArrayDeque<>();
        int n = arr.length;
        int res[] = new int[n-k+1];
        // Process first k elements separately
        for(int i = 0;i<k;i++){
            while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        //process for rest of the elements
        for(int i = k;i<n;i++){
            res[i-k] = arr[deque.peekFirst()];
            //remove ele outside curr window
            while (!deque.isEmpty() && deque.peekFirst() <= i-k) {
                deque.removeFirst();
                
            }

            //remove elements smaller than current element
            while (!deque.isEmpty() && arr[deque.peekLast() ] <= arr[i]) {
                deque.removeLast();
                
            }
            deque.addLast(i);
        }
        res[n-k] = arr[deque.peekFirst()];
        return res;
    } 
    public static void main(String[] args) {
        // Test case
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        int[] result = findMaxInSubarrays(arr, k);
        System.out.println("Maximum elements in subarrays of size " + k + ":");
        for (int max : result) {
            System.out.print(max + " ");
        }
    }
}


//https://claude.site/artifacts/8737b9fe-f1aa-4dd0-b068-502618616a95