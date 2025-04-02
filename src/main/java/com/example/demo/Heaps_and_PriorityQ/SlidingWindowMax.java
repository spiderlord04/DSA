package com.example.demo.Heaps_and_PriorityQ;

import java.util.PriorityQueue;


// # 239 LeetCode .........



public class SlidingWindowMax {
    static class Solution {
        static class Pair implements Comparable<Pair> {
            int idx;
            int val;
    
            public Pair(int idx, int val) {
                this.idx = idx;
                this.val = val;
            }
    
            // Defining the sorting logic
            @Override
            public int compareTo(Pair p2) {
                // in descending order
                return p2.val - this.val; // Alternatively, use Integer.compare(p2.val, this.val) to prevent overflow
            }
        }
    
        public int[] maxSlidingWindow(int[] nums, int k) {
            // The result array size will be nums.length - k + 1
            int res[] = new int[nums.length - k + 1];
    
            // Make a Priority Queue to implement the sliding window effect
            PriorityQueue<Pair> pq = new PriorityQueue<>();
    
            // Step 1: Add first K elements to PQ
            for (int i = 0; i < k; i++) {
                pq.add(new Pair(i, nums[i]));
            }
    
            // Step 2: As we are using Max Heap, the first element is the maximum element of that window.
            // So, we take the first element and add it to the result array.
            res[0] = pq.peek().val; // for the first window
    
            // Step 3: At max, our PQ can store only K elements, so we remove the previous elements.
            // To do that, we check if the peek element is out of the window index.
            // Example: The 2nd window starts from idx 1, and if the peek element idx = 0, then that element is out of the window, so we remove it.
            for (int i = k; i < nums.length; i++) {
                // Remove all the elements that are out of the window
                while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                    pq.remove();
                }
                // Step 4: We add the current element to the window if it is not out of the window
                pq.add(new Pair(i, nums[i]));
    
                // Step 5: Now add the peek to res, as the peek is the max element
                res[i - k + 1] = pq.peek().val;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        // SlidingWindowMax obj = new SlidingWindowMax();
        Solution s = new Solution();
        // [1,3,-1,-3,5,3,6,7], k = 3
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = s.maxSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    
}
