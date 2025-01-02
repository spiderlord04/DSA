package com.example.demo.Queues.QuestionsHW;
/*
 * Question 3 :
Job Sequencing Problem
We have an array of jobs where every job has a deadline and associated prot if the job is
nished before the deadline. It is also given that every job takes a single unit of time, so the
minimum possible deadline for any job is 1. Maximize the total prot if only one job can be
scheduled at a time.
Sample Input 1 :
JobID Deadline Prot
a 4 20
b 1 10
c 1 40
d 1 30
Sample Output 1 : c, a
 */

 import java.util.*;
public class JobSequencing {
    public static  void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        
        int deadline[] = {4,1,1,1};
        int prot[] = {20,10,40,30};
        char job[] = {'a','b','c','d'};
        for(int i = 0;i<deadline.length-1;i++){
            for(int j = 0;j<deadline.length-i-1;j++){
                if(prot[j] < prot[j+1]){
                    swap(deadline,j,j+1);
                    swap(prot,j,j+1);
                    char temp = job[j];
        job[j] = job[j+1];
        job[j+1] = temp;

                    
                }
            }
        }

        //time slots 
        int max = Arrays.stream(deadline)
                                 .max()
                                 .orElseThrow(() -> new IllegalArgumentException("Array is empty"));
                      System.out.println(max);
        int timeslot[] = new int[max];
        Arrays.fill(timeslot, -1);

        // Array to store the result jobs that are selected
        char[] result = new char[max];

        // Job scheduling
        for (int i = 0; i < job.length; i++) {
            // Find a free slot for this job
            for (int j = deadline[i] - 1; j >= 0; j--) {
                if (timeslot[j] == -1) { // Slot is free
                    timeslot[j] = 1; // Mark this slot as occupied
                    result[j] = job[i]; // Assign the job to this slot
                    break; // Move to the next job
                }
            }
        }

        // Print the scheduled jobs
        System.out.println("\nScheduled Jobs:");
        for (int i = 0; i < max; i++) {
            if (result[i] != 0) { // Only print non-empty slots
                System.out.print(result[i] + " ");
            }
        }

        /*
         * Time Complexity: O(n^2);
         * Space : O(n);
         */
    }
}

/*
 * ACTUAL PROVIDED
 * 
 * Solution 3 :
Time Complexity : o(nlogn)
Space Complexity: o(n)
import java.util.*;
class Solution {
static class Job {
char job_id;
int deadline;
int prot;

Job(char job_id, int deadline, int prot){
this.deadline = deadline;
this.job_id = job_id;
this.prot = prot;
}
}
static void printJobScheduling(ArrayList<Job> arr){
int n = arr.size();
Collections.sort(arr, (a, b) -> {
return a.deadline - b.deadline;
});
ArrayList<Job> result = new ArrayList<>();
PriorityQueue<Job> maxHeap = new PriorityQueue<>(
(a, b) -> { return b.prot - a.prot; });
for (int i = n - 1; i > -1; i--) {
int slot_available;
if (i == 0) {
slot_available = arr.get(i).deadline;
}
else {
slot_available = arr.get(i).deadline
- arr.get(i - 1).deadline;
}
maxHeap.add(arr.get(i));
while (slot_available > 0
&& maxHeap.size() > 0) {
Job job = maxHeap.remove();
slot_available--;
result.add(job);
}
}
Collections.sort(result, (a, b) -> {
return a.deadline - b.deadline;
});
for (Job job : result) {
System.out.print(job.job_id + " ");
}

System.out.println();
}
public static void main(String[] args){
ArrayList<Job> arr = new ArrayList<Job>();
arr.add(new Job('a', 2, 100));
arr.add(new Job('b', 1, 19));
arr.add(new Job('c', 2, 27));
arr.add(new Job('d', 1, 25));
arr.add(new Job('e', 3, 15));
System.out.println("Following is maximum "
+ "prot sequence of jobs");
printJobScheduling(arr);
}
}
 */

