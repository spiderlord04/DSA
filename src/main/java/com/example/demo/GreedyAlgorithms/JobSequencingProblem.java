package com.example.demo.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//Q : Given an array of jobs where every job has a deadline and profit if the job is finished before the deadline. It is also given that every job takes a single unit of time , so the minimum possible deadline for any job is 1. Maximize the total profit if only job can be scheduled at a time.

// Job A = 4,20

// Job B = 1,10

// Job C = 1, 40

// Job D = 1, 30
// ans = C,A

public class JobSequencingProblem {
     static class Job{
        int id;
        int deadline;
        int profit;

        public Job(int id,int deadline,int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
//Array list store karne k leye  sabli jobs ko
ArrayList<Job> jobs = new ArrayList<>();
for(int i = 0 ;i<jobInfo.length;i++){
//store karten hai 
jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));

}

//obj sorting based on profit,descending 
//for sorting objects in descending the following
Collections.sort(jobs,(obj1,obj2) -> obj2.profit-obj1.profit);//just reverse the logic obj1-obj2 for ascending..
//main logic
//take a time var for upadting teh completed job time
int time = 0;
ArrayList<Integer> seq = new ArrayList<>();


for(int i = 0;i<jobs.size();i++){
Job curr = jobs.get(i);
if(curr.deadline>time){
    time++;
    seq.add(curr.id);
}
}
System.out.println("Max jobs =" + seq.size());
for(int i = 0;i<seq.size();i++){
    System.out.print(seq.get(i)+" ");
}
    }
}
