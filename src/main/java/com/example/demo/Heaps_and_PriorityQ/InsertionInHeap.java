package com.example.demo.Heaps_and_PriorityQ;

import java.util.ArrayList;

public class InsertionInHeap {
    static ArrayList<Integer> heap = new ArrayList<>();;

    // public InsertionInHeap() {
    // heap = new ArrayList<>();
    // }
    public static void insert(int data){
        //step1 -> add at last index 
        heap.add(data);
        //step 2 -> fix the heap property
        //to get the parent index we use formula (i-1)/2
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;
        // and for min heap the conditionn is parentval <= childval

        while(heap.get(childIndex)< heap.get(parentIndex)){
            //if so then swap 
            int temp = heap.get(childIndex);
            heap.set(childIndex,heap.get(parentIndex));
            heap.set(parentIndex,temp);
             // Update the childIndex and parentIndex for the next iteration
             childIndex = parentIndex;
             parentIndex = (childIndex - 1) / 2;
        }

        //deletion 
    }
    public static void heapify(int i){
        int left = i*2+1;
        int right = i*2+2;
        int min = i;
        if(left<heap.size() && heap.get(left)<heap.get(min)){
            min = left;
        }
        if(right < heap.size() && heap.get(right)<heap.get(min)){
            min = right;
        }
        //if the value  of  min is changed
         if(min != i){
            //then swap the min and i ..
            int temp = heap.get(i);
            heap.set(i, heap.get(min));
            heap.set(min,temp);

            //and cll the hepify becauuse there might be a another node whhich has been changed
            heapify(min);
         }
    }
    public static int removeFromHeap(){
        //step ! swap first element with last
        int data = heap.get(0);
        int temp = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.set(heap.size()-1,temp);
        //setep 2 : delte last elemetn
        heap.remove(heap.size()-1);
        //step 3: fix the heap by heapidy method
        heapify(0); // 0 is the tree node
        return data;


    }

    public static void main(String[] args) {
        insert(10);
        insert(5);
        insert(1);
        insert(6);
        insert(4);
        System.out.println(heap);
        removeFromHeap();
        System.out.println(heap);
    }
}
