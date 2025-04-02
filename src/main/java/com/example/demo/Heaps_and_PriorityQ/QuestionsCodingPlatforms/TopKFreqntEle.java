package com.example.demo.Heaps_and_PriorityQ.QuestionsCodingPlatforms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// #347 Leetcode...

public class TopKFreqntEle {
    class Solution {
        static class CountNum implements Comparable<CountNum>{
            int val ;
            int count;
            public CountNum(int val,int count){
                this.val = val;
                this.count = count;
            }
            @Override
            public int compareTo(CountNum c2){
                return c2.count - this.count;
            }
        }
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer,Integer> freq = new HashMap<>();
            for(int ele : nums){
                freq.put(ele , freq.getOrDefault(ele,0)+1);
            }
            PriorityQueue<CountNum> p = new PriorityQueue<>();
            for(Map.Entry<Integer,Integer>entry: freq.entrySet()){
                p.add(new CountNum(entry.getKey(),entry.getValue()));
            }
            int res[] = new int[k];
            for(int i = 0;i<k;i++){
                res[i] = p.remove().val;
            }
            return res;
        }
    }
}
